package tw.TogetherLearning.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.TogetherLearning.model.PointRecords;
import tw.TogetherLearning.model.PointsService;
import tw.TogetherLearning.model.Student;
import tw.TogetherLearning.model.StudentRepository;
import tw.TogetherLearning.model.StudentService;
import tw.TogetherLearning.model.TestQuestions;
import tw.TogetherLearning.model.TestQuestionsRepository;
import tw.TogetherLearning.model.TestRecords;
import tw.TogetherLearning.model.TestRecordsRepository;
import tw.TogetherLearning.model.TestRecordsService;
import tw.TogetherLearning.model.TestSubjects;
import tw.TogetherLearning.model.TestSubjectsRepository;
import tw.TogetherLearning.model.Tests;
import tw.TogetherLearning.model.TestsRepository;



@Controller
public class TestCenterController {
	
	@Autowired
	TestSubjectsRepository tsRep;
	
	@Autowired
	TestsRepository tRep;
	
	@Autowired
	TestRecordsRepository trRep;
	
	@Autowired
	TestQuestionsRepository tqRep;
	
	@Autowired
	StudentRepository stuRep;
	
	@Autowired
	TestRecordsService trService;
	
	@Autowired
	StudentService stuService;
	
	@Autowired
	PointsService pService;

	

//==========================================================================================================//	
//                                             測驗中心                                                      //
//==========================================================================================================//	
	
	//-------------------------------------------科目-----------------------------------------------//
	
	
	@RequestMapping(value = "/testSubjects")//localhost:8080/testSubjects
	public ModelAndView testSubjects(HttpServletRequest request, HttpServletResponse response){  
		
		List<TestSubjects> testSubjectDataList = tsRep.findAll();
		
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("/testSubjects");//返回路径==>jsp  
		mav.addObject("testSubjectList", testSubjectDataList);
		
		return mav;
	} 


	//-------------------------------------------測驗介紹-----------------------------------------------//
	
	@RequestMapping(value = "/test-entery")//localhost:8080/test-entery
	public ModelAndView testEntery(HttpServletRequest request, HttpServletResponse response,@RequestParam(name="testId") int tId){  
		
		Tests test = tRep.findByTestId(tId);  
		List<TestQuestions> testQuestionsDataList = tqRep.findByTestId(test.getTestId());
		Student student = stuRep.findBystudentId(2); //studentId之後要改成從session裡抓取，而非寫死
		PointRecords pointReco = new PointRecords();
		
		
		int stuPoint = student.getStudentPoints();
		int testRequiredPoints = test.getTestRequiredPoints();
		int negativeCourPoint = -testRequiredPoints;
		Date changedDate = new Date();
		String reminder = null;
		
		if(stuPoint > testRequiredPoints) {
			
			//扣點數
			student.setStudentPoints(stuPoint-testRequiredPoints);
			stuService.update(student);
			
			//儲存點數異動紀錄
			pointReco.setStudentId(student.getStudentId());
			pointReco.setPoints(negativeCourPoint);
			pointReco.setChangedReason("測驗(使用點數)");
			pointReco.setChangedDate(changedDate);
			
			pService.insert(pointReco);
			
		}

		ModelAndView mav=new ModelAndView();  
		mav.setViewName("/testEntery");//返回路径==>jsp  
		mav.addObject("test", test);
		mav.addObject("testQuestionsList", testQuestionsDataList);
		mav.addObject("student", student);
//		mav.addObject("reminder", reminder);
		
		
		return mav;
	}
	
	
	//---------------------------------------------測驗-----------------------------------------------//
	
	@RequestMapping(value = "/test")//localhost:8080/test
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response, @RequestParam(name="testId") int tId,
			@RequestParam(name ="studentId")int sId){  
		
		Tests test = tRep.findByTestId(tId);
		List<TestQuestions> testQuestionsDataList = tqRep.findByTestId(test.getTestId());
		Student student = stuRep.findBystudentId(sId);
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("/test");//返回路径==>jsp  
		mav.addObject("test", test);
		mav.addObject("testQuestionsList", testQuestionsDataList);
		mav.addObject("student", student);


		return mav;
	} 
	
	//--------------------------------------------計算成績----------------------------------------------//
	
	@RequestMapping(value = "/countAnswer")
	public String countAnswer(HttpServletRequest request,@RequestParam(name="q0") String answer0,@RequestParam(name="q1")String answer1,
			@RequestParam(name="q2")String answer2,@RequestParam(name="q3")String answer3,@RequestParam(name="q4")String answer4,
			@RequestParam(name="q5")String answer5,@RequestParam(name="q6")String answer6,@RequestParam(name="q7")String answer7,
			@RequestParam(name="q8")String answer8,@RequestParam(name="q9")String answer9,@RequestParam(name="testId")int tId,
			@RequestParam(name ="studentId")int sId,RedirectAttributes testRecordId) {
		
		List<TestQuestions> testQuestionsDataList = tqRep.findByTestId(tId); //透過接收到的tId來查詢該測驗的所有題目
		TestRecords testRecord = new TestRecords(); //新的一筆測驗紀錄

		String[] stuAnswerArray = {answer0,answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9};//將所有answer放進陣列
		List<String> stuAnswerList = new ArrayList<>(Arrays.asList(stuAnswerArray));//再將answer陣列轉成list
		
		String allStudentAnswer = String.join(",",stuAnswerArray); //將answer轉string，存進資料庫用

		
		//從前端接收到的學生answer長"題目編號|選項"這樣，因此需要將題目編號與選項分開
        String studentAnswer;
        int questionId;
        int studentGrade = 0;
        
        for(String data:stuAnswerList) {

        	questionId =  Integer.parseInt(data.split("\\|")[0]);
        	studentAnswer = data.split("\\|")[1];
        	
        	for(TestQuestions dataQuestion:testQuestionsDataList) {
        		
        		if( questionId == dataQuestion.getTestQuestionId() && studentAnswer.equals(dataQuestion.getAnswer())) {
        			
        			studentGrade += 10;

        		}
        	}     
        }
        
        testRecord.setStudentId(sId);
        testRecord.setTestId(tId);
        testRecord.setTestDate(new Date());
        testRecord.setTestGrade(studentGrade);
        testRecord.setStudentAnswer(allStudentAnswer);
        
        trService.insert(testRecord);
        
        testRecordId.addAttribute("testRecordId", testRecord.getTestRecordId());
        
		return "redirect:/testResult";
	}
	
	
	

	//---------------------------------------------測驗成績-----------------------------------------------//
	
	@RequestMapping(value = "/testResult")//localhost:8080/testResult
	public ModelAndView testResult(HttpServletRequest request, HttpServletResponse response,@RequestParam(name="testRecordId") int trId){  
		
		
		
		TestRecords testRecord = trRep.findById(trId); //之後要改成從session抓
		List<TestQuestions> testQuestionsDataList = tqRep.findByTestId(testRecord.getTestId());
		List<Map<String,Object>> qaList = new ArrayList<Map<String,Object>>();
		//設一個list，裡面放map，透過map把學生的每題答案配對上每一個TestQuestions
		HashMap<String, Object> qaMap;
		//透過map把學生的每題答案配對上每一個TestQuestion
		
		String stuAnswer = testRecord.getStudentAnswer();  //取出學生答案的字串
		String[] stuAnswerSplit = stuAnswer.split(",");  //利用逗號將字串切割，轉成陣列
       
        //-----------------將陣列轉list-----------------
        List<String> stuAnswerList = new ArrayList<>();  
        
        for (int i=0; i<stuAnswerSplit.length; i++) {       	
        	stuAnswerList.add(stuAnswerSplit[i]); 	
        }
        //----------------------------------------------
        
//      String[]  dataArray;
        String studentAnswer;
        int questionId;
        
        for(String data:stuAnswerList) {
        	
//        	dataArray= data.split("\\|"); ==========>   \\| 為跳脫字元 等於 |
        	questionId =  Integer.parseInt(data.split("\\|")[0]);
        	studentAnswer = data.split("\\|")[1];
        	
        	for(TestQuestions dataQuestion:testQuestionsDataList) {
        		
        		if( questionId == dataQuestion.getTestQuestionId() ) {
        			qaMap = new HashMap<String, Object>(); 
        			//每跑一次迴圈就new一個HashMap，將學生的每題答案配對上每一個TestQuestion，所以迴圈外先宣告空的參數即可
        			qaMap.put("studentAnswer", studentAnswer);
        			qaMap.put("dataQuestion", dataQuestion);
        			
        			qaList.add(qaMap);
        		}
        	}
        }
        
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("/testResult");//返回路径==>jsp  
		mav.addObject("testRecord", testRecord);
		mav.addObject("qaList", qaList);

		
		return mav;
	} 
	


}
