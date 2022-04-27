package tw.TogetherLearning.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity	@Table(name = "test_records")
@Component
public class TestRecords {
	
	@Id @Column(name = "TEST_RECORD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testRecordId;
	
	@Column(name = "STUDENT_ID")
	private int studentId;
	
	@Column(name = "TEST_ID")
	private int testId;
	
	@Column(name = "TEST_DATE")
	private Date testDate;
	
	@Column(name = "TEST_GRADE")
	private int testGrade;
	
	@Column(name = "STUDENT_ANSWER")
	private String studentAnswer;

	
	
	public int getTestRecordId() {
		return testRecordId;
	}

	public void setTestRecordId(int testRecordId) {
		this.testRecordId = testRecordId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getTestGrade() {
		return testGrade;
	}

	public void setTestGrade(int testGrade) {
		this.testGrade = testGrade;
	}

	public String getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}


	
	
}
