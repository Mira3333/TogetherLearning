package tw.TogetherLearning.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity @Table(name = "courses")
@Component
public class Courses {
	
	@Id @Column(name = "COURSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@Column(name = "TUTOR_ID")
	private int tutorId;

	@Column(name = "SUBJECT_ID")
	private int subjectId;
	
	@Column(name = "INTRO_TITLE")
	private String introTitle;
	
	@Column(name = "INTRO_CONTENTS")
	private String introContents;
	
	@Column(name = "INTRO_VIDEO")
	private String introVideo;

	@Column(name = "INTRO_PHOTO")
	private String introPhoto;
	
	@Column(name = "REQUIRED_POINTS")
	private int requiredPoints;
	
	@OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "tutorId", referencedColumnName = "tutorId")
	private Tutors tutors;
	//在Courses裡面join tutors的tutorId
	
//	//關連到CourseRecords裡面的courses物件
//	@OneToOne(mappedBy = "courses",fetch=FetchType.LAZY)
//	private CourseRecords courseRecords;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courses")
	private List<CourseRecords> courseRecords;

	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getIntroTitle() {
		return introTitle;
	}

	public void setIntroTitle(String introTitle) {
		this.introTitle = introTitle;
	}

	public String getIntroContents() {
		return introContents;
	}

	public void setIntroContents(String introContents) {
		this.introContents = introContents;
	}

	public String getIntroVideo() {
		return introVideo;
	}

	public void setIntroVideo(String introVideo) {
		this.introVideo = introVideo;
	}
	
	public String getIntroPhoto() {
		return introPhoto;
	}
	
	public void setIntroPhoto(String introPhoto) {
		this.introPhoto = introPhoto;
	}

	public int getRequiredPoints() {
		return requiredPoints;
	}

	public void setRequiredPoints(int requiredPoints) {
		this.requiredPoints = requiredPoints;
	}

	public Tutors getTutors() {
		return tutors;
	}

	public void setTutors(Tutors tutors) {
		this.tutors = tutors;
	}

	public List<CourseRecords> getCourseRecords() {
		return courseRecords;
	}

	public void setCourseRecords(List<CourseRecords> courseRecords) {
		this.courseRecords = courseRecords;
	}


	
		
	
}
