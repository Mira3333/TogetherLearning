package tw.TogetherLearning.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tw.TogetherLearning.model.CourseRecords;
import tw.TogetherLearning.model.CourseRecordsRepository;
import tw.TogetherLearning.model.CourseRecordsService;
import tw.TogetherLearning.model.Courses;
import tw.TogetherLearning.model.CoursesRepository;
import tw.TogetherLearning.model.JsonAcepter;
import tw.TogetherLearning.model.PointRecords;
import tw.TogetherLearning.model.PointsService;
import tw.TogetherLearning.model.Student;
import tw.TogetherLearning.model.StudentRepository;
import tw.TogetherLearning.model.StudentService;
import tw.TogetherLearning.model.Subjects;
import tw.TogetherLearning.model.SubjectsRepository;
import tw.TogetherLearning.model.Tutors;
import tw.TogetherLearning.model.TutorsRepository;

@Controller
public class ChooseCourseController {
	
	@Autowired
	CoursesRepository cRep;
	
	@Autowired
	TutorsRepository tRep;
	
	@Autowired
	SubjectsRepository sRep;
	
	@Autowired
	CourseRecordsRepository courRecoRep;
	
	@Autowired
	StudentRepository stuRep;
	
	@Autowired
	PointsService pService;
	
	@Autowired
	StudentService stuService;
	
	@Autowired
	CourseRecordsService CourRecoService;

//==========================================================================================================//	
//                                                  我的課表                                                //
//==========================================================================================================//	
	//-------------------------------------------課表-----------------------------------------------//

	@RequestMapping(value = "/myschedule")//localhost:8080/myschedule
	public ModelAndView myschedule(HttpServletRequest request, HttpServletResponse response){  
		
		List<CourseRecords> courRecoDataList = CourRecoService.findByStudentIdOrderByCourseDateAsc(3); //把CourseRecords裡面的所有資料叫出來
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("/myschedule");//返回路径==>jsp  
		mav.addObject("courRecoList", courRecoDataList);//使用ModelAndView的addObject方法将List<CourseRecords> courRecoDataList放進去  

		return mav;
	} 
	
	//----------------------------------------取消選課功能---------------------------------------------//
	
	@RequestMapping(value = "/deleteCourseRecord")
	public String deleteCourseRecord(HttpServletRequest request, @RequestParam(value = "courseRecordId") int crId,
			@RequestParam(value = "studentId") int sId) {
		
		CourRecoService.daleteCourseRecord(crId, sId);
		
		return "redirect:/myschedule";
	}
	
	
//==========================================================================================================//	
//                                                 科目分類                                                 //
//==========================================================================================================//		
	
	@RequestMapping(value = "/subjects")//localhost:8080/subjects
	public ModelAndView subjects(HttpServletRequest request, HttpServletResponse response){  
		
		List<Subjects> subjectDataList = sRep.findAll(); //把subject裡面的所有資料叫出來
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("/subjects");//返回路径==>jsp  
		mav.addObject("subjectList", subjectDataList);//使用ModelAndView的addObject方法将List<Subjects> subjectList放進去  
		
		return mav;
	} 
	
	
//==========================================================================================================//	
//                                                 各科老師一覽表                                            //
//==========================================================================================================//	

	
	@RequestMapping(value = "/courses")//localhost:8080/courses
	public ModelAndView courses(HttpServletRequest request, HttpServletResponse response , @RequestParam(value = "subjectId") int sId){  
		
		List<Courses> courseDataList = cRep.findBySubjectId(sId); //把course裡面同一個SubjectId的所有資料叫出來
		Subjects subjects = sRep.findBySubjectId(sId);
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("/subTutors");//返回路径==>jsp  
		mav.addObject("courseList", courseDataList);//使用ModelAndView的addObject方法将List<Subjects> subjectList放進去  
		mav.addObject("subjects", subjects);//使用ModelAndView的addObject方法将List<Subjects> subjectList放進去  
		
		return mav;
	} 
	
//==========================================================================================================//	
//                                            課程詳細介紹及選課頁面                                         //
//==========================================================================================================//	
	
//-------------課程介紹需要取用Courses & tutors table ; 選課功能需要存到course_records table-------------//
	
	@RequestMapping(value = "/courseDetail")//localhost:8080/courseDetail
	public ModelAndView courseDetail(HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(value = "courseId") int cId, @RequestParam(value = "reminder",required=false) String reminder){  
		
		Courses courses = cRep.findByCourseId(cId);
		Tutors tutors = tRep.findByTutorId(courses.getTutorId());//findByTutorId取的TutorId是從courses的getTutor_id()取的
		
	    ModelAndView mav=new ModelAndView();  
	    mav.setViewName("/courseDetail"); //返回路径==>jsp  
	    
	    mav.addObject("courses", courses); //使用ModelAndView的addObject方法将course放進去  
	    mav.addObject("tutors", tutors); //使用ModelAndView的addObject方法將tutors放進去 ("tutors"==>key, tutors==>value) 
	    mav.addObject("reminder", reminder);
	    
	    return mav;  
	} 
	
////-------------------------------------------選課功能-----------------------------------------------//
	
	@RequestMapping(value = "/addCourseRecord",method = RequestMethod.POST)
	public ResponseEntity<?> addCourseRecord(@RequestBody JsonAcepter data) throws Exception {
		
		
		int cId = data.getCourseId();
		int sId = data.getStudentId();
		int subId = data.getSubjectId();
		int rPoints = data.getRequiredPoints();
		String tName = data.getTutorName();
		String cDate = data.getCourseDate();
		String cTime = data.getCourseTime();
		
				
		CourseRecords courReco = new CourseRecords();
		PointRecords pointReco = new PointRecords();
		Student student = stuRep.findBystudentId(sId);
		Courses courses = cRep.findByCourseId(cId);
		
		System.out.println("123123");
		
		String courseDate = cDate +" "+ cTime; 
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		CourseRecords courRecoCheckDateTime = courRecoRep.findByCourseIdAndCourseDate(cId, format.parse(courseDate));
		List<CourseRecords> courRecoCheckFirstCourse = courRecoRep.findBySubjectIdAndStudentId(subId, sId);
		System.out.println("121456464");
		
		int stuPoint = student.getStudentPoints();
		int courPoint = courses.getRequiredPoints();
		int negativeCourPoint = -courPoint;
		
		String reminder = null;
		Date changedDate = new Date();
		

		if(stuPoint < courPoint) {
			
			reminder = "選課失敗，您的點數不足。歡迎至購物商城購買點數！";
			
		}else if(courRecoCheckDateTime != null) {
			
			reminder = "選課失敗，該時段已額滿。請選擇其他時段！";
		
		}else if(courRecoCheckFirstCourse.size() == 0 ) {
			
			reminder = "選課成功！您為首次選課，建議在上課前先至測驗中心做能力測驗，以供老師教學評估。";
			
			//扣點數
			student.setStudentPoints(stuPoint-courPoint);
			stuService.update(student);
			
			//儲存選課紀錄
			courReco.setCourseId(cId);
			courReco.setStudentId(sId);
			courReco.setSubjectId(subId);
			courReco.setCourseDate(format.parse(courseDate));
			courReco.setRequiredPoints(rPoints);
			courReco.setTutorName(tName);
			
			CourRecoService.insert(courReco);
			
			//儲存點數異動紀錄
			pointReco.setStudentId(sId);
			pointReco.setPoints(negativeCourPoint);
			pointReco.setChangedReason("選課(使用點數)");
			pointReco.setChangedDate(changedDate);
			
			pService.insert(pointReco);
			
			
			
		}else {
			
			reminder = "選課成功！";
			
			//扣點數
			student.setStudentPoints(stuPoint-courPoint);
			stuService.update(student);
			
			//儲存選課紀錄
			courReco.setCourseId(cId);
			courReco.setStudentId(sId);
			courReco.setSubjectId(subId);
			courReco.setCourseDate(format.parse(courseDate));
			courReco.setRequiredPoints(rPoints);
			courReco.setTutorName(tName);
			
			CourRecoService.insert(courReco);
			
			//儲存點數異動紀錄
			pointReco.setStudentId(sId);
			pointReco.setPoints(negativeCourPoint);
			pointReco.setChangedReason("選課(使用點數)");
			pointReco.setChangedDate(changedDate);
			
			pService.insert(pointReco);
			
		}
		
		
		System.out.println("78964");

		return ResponseEntity.ok(reminder);
	
	}
	
	
//------------------------------------------------------------------------------------------------------------//	
//                                             選課：redirect的方式                                            //
//------------------------------------------------------------------------------------------------------------//	
	
//	@RequestMapping(value = "/addCourseRecord")
//	public String addCourseRecord(HttpServletRequest request, @RequestParam(value = "courseId") int cId,
//			@RequestParam(value = "studentId") int sId, @RequestParam(value = "subjectId") int subId,
//			@RequestParam(value = "courseDate") String cDate,@RequestParam(value = "courseTime") String cTime,
//			@RequestParam(value = "requiredPoints") int rPoints,@RequestParam(value = "tutorName") String tName,
//			RedirectAttributes redirectAttributes) throws ParseException {
//		
//		
//		CourseRecords courReco = new CourseRecords();
//		PointRecords pointReco = new PointRecords();
//		Student student = stuRep.findBystudentId(sId);
//		Courses courses = cRep.findByCourseId(cId);
//		
//		String courseDate = cDate +" "+ cTime; 
//		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		
//		CourseRecords courRecoCheckDateTime = courRecoRep.findByCourseIdAndCourseDate(cId, format.parse(courseDate));
//		List<CourseRecords> courRecoCheckFirstCourse = courRecoRep.findBySubjectIdAndStudentId(subId, sId);
//		
//		int stuPoint = student.getStudentPoints();
//		int courPoint = courses.getRequiredPoints();
//		int negativeCourPoint = -courPoint;
//		
//		String reminder = null;
//		Date changedDate = new Date();
//		
//		
//		if(stuPoint < courPoint) {
//			
//			reminder = "選課失敗，您的點數不足。歡迎至購物商城購買點數！";
//			
//		}else if(courRecoCheckDateTime != null) {
//			
//			reminder = "選課失敗，該時段已額滿。請選擇其他時段！";
//			
//		}else if(courRecoCheckFirstCourse.size() == 0 ) {
//			
//			reminder = "選課成功！您為首次選課，建議在上課前先至測驗中心做能力測驗，以供老師教學評估。";
//			
//			//扣點數
//			student.setStudentPoints(stuPoint-courPoint);
//			stuService.update(student);
//			
//			//儲存選課紀錄
//			courReco.setCourseId(cId);
//			courReco.setStudentId(sId);
//			courReco.setSubjectId(subId);
//			courReco.setCourseDate(format.parse(courseDate));
//			courReco.setRequiredPoints(rPoints);
//			courReco.setTutorName(tName);
//			
//			CourRecoService.insert(courReco);
//			
//			//儲存點數異動紀錄
//			pointReco.setStudentId(sId);
//			pointReco.setPoints(negativeCourPoint);
//			pointReco.setChangedReason("選課(使用點數)");
//			pointReco.setChangedDate(changedDate);
//			
//			pService.insert(pointReco);
//			
//			
//			
//		}else {
//			
//			//扣點數
//			student.setStudentPoints(stuPoint-courPoint);
//			stuService.update(student);
//			
//			//儲存選課紀錄
//			courReco.setCourseId(cId);
//			courReco.setStudentId(sId);
//			courReco.setSubjectId(subId);
//			courReco.setCourseDate(format.parse(courseDate));
//			courReco.setRequiredPoints(rPoints);
//			courReco.setTutorName(tName);
//			
//			CourRecoService.insert(courReco);
//			
//			//儲存點數異動紀錄
//			pointReco.setStudentId(sId);
//			pointReco.setPoints(negativeCourPoint);
//			pointReco.setChangedReason("選課(使用點數)");
//			pointReco.setChangedDate(changedDate);
//			
//			pService.insert(pointReco);
//			
//		}
//		
//		redirectAttributes.addAttribute("courseId", cId);  //redirect至courseDetail，並帶參數，參數key要與目的地接收參數的value名一樣
//		redirectAttributes.addAttribute("reminder", reminder); //redirect至courseDetail，並帶參數，參數key要與目的地接收參數的value名一樣
//		
//		
//		
//		return "redirect:/courseDetail";
//		
//	}

}
