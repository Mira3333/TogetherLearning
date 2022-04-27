package tw.TogetherLearning.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRecordsRepository extends JpaRepository<CourseRecords, Integer> {
	

	public CourseRecords findByCourseRecordId(int courseRecordId); //courseRecordId為主鍵，因此只會有一筆

	public CourseRecords findByCourseIdAndCourseDate(int courseId , Date courseDate);

	public List<CourseRecords> findBySubjectIdAndStudentId(int subjectId , int studentId);

	public List<CourseRecords> findByStudentIdOrderByCourseDateAsc(int studentId); //studentId有多筆，因此要用list裝起來
	
}
