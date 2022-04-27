package tw.TogetherLearning.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity	@Table(name = "points")
@Component
public class PointRecords {
	
	@Id @Column(name = "PONIT_RECORD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pointRecordId;
	
	@Column(name = "STUDENT_ID")
	private int studentId;
	
	@Column(name = "POINTS")
	private int points;
	
	@Column(name = "CHANGED_REASON")
	private String changedReason;
	
	@Column(name = "CHANGED_DATE")
	private Date changedDate;

	public int getPointRecordId() {
		return pointRecordId;
	}

	public void setPointRecordId(int pointRecordId) {
		this.pointRecordId = pointRecordId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getChangedReason() {
		return changedReason;
	}

	public void setChangedReason(String changedReason) {
		this.changedReason = changedReason;
	}

	public Date getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	

	
}
