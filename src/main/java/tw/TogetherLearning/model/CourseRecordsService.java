package tw.TogetherLearning.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseRecordsService {
	
	@Autowired
	private CourseRecordsRepository courRecoRep;
	
	@Autowired
	private StudentRepository stuRep;
	
	
	@Autowired
	private StudentService stuService;
	
	
	@Autowired
	private PointsService pService;
	
	
	
//--------------------------------------新增選課-------------------------------------------	
	public CourseRecords insert(CourseRecords courReco) {
		return courRecoRep.save(courReco);		
	}
	
//-----------------------------------取消選課功能-------------------------------------------	
	public void daleteCourseRecord(Integer courseRecordId , Integer studentId) {
		
		CourseRecords courseRecord = courRecoRep.findByCourseRecordId(courseRecordId);
		Student student = stuRep.findBystudentId(studentId);
		PointRecords pointReco = new PointRecords();
		
		int rPoint = courseRecord.getRequiredPoints();
		int stuPoint = student.getStudentPoints();
		Date changedDate = new Date();
		
		//加回點數
		student.setStudentPoints(stuPoint+rPoint);
		stuService.update(student);
		
		//新增點數異動紀錄
		pointReco.setStudentId(studentId);
		pointReco.setPoints(rPoint);
		pointReco.setChangedReason("取消選課(退還點數)");
		pointReco.setChangedDate(changedDate);
		
		pService.insert(pointReco);
		
		
		courRecoRep.deleteById(courseRecordId);
	}
//-----------------------------------顯示所有選課-------------------------------------------	
	public List<CourseRecords> findByStudentIdOrderByCourseDateAsc(int studentId){
		
		List<CourseRecords> courRecoDataList = courRecoRep.findByStudentIdOrderByCourseDateAsc(studentId); //把CourseRecords裡面的所有資料叫出來

		//將宣告放for迴圈外面，提供迴圈重複使用，若放裡面的話，變成每跑一次迴圈就宣告一次，占用效能
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd HH");
		String string,strDate,strTime; // ==> String string;   String strDate;   String strTime;
		
		for(CourseRecords data:courRecoDataList) {
			
			string = format.format(data.getCourseDate());
			strDate = string.substring(0, 10);
			strTime = string.substring(11, 13);
			
			
			data.setStringDate(strDate);
			data.setStringTime(strTime+":00 - "+strTime+":50");
		}
		
		return courRecoRep.findByStudentIdOrderByCourseDateAsc(studentId);
	}
	
}
