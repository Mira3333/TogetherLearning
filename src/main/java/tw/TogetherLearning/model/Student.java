package tw.TogetherLearning.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;




@Entity @Table(name = "student") 
@Component 
public class Student {
	
	@Id @Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;

	@Column(name = "STUDENT_POINTS")
	private int studentPoints;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentPoints() {
		return studentPoints;
	}

	public void setStudentPoints(int studentPoints) {
		this.studentPoints = studentPoints;
	}


	

}
