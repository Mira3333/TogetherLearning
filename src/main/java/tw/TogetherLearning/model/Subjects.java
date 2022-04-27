package tw.TogetherLearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity	@Table(name = "subjects")
@Component
public class Subjects {
	
	@Id @Column(name = "SUBJECT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	
	@Column(name = "SUBJECT")
	private String subject;
	
	@Column(name = "SUBJECT_PHOTO")
	private String subjectPhoto;
	
	@Column(name = "SUBJECT_DETAIL")
	private String subjectDetail;
	
	@Column(name = "SUBJECT_INTRO_CONTENTS")
	private String subjectIntroContents;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectPhoto() {
		return subjectPhoto;
	}

	public void setSubjectPhoto(String subjectPhoto) {
		this.subjectPhoto = subjectPhoto;
	}

	public String getSubjectDetail() {
		return subjectDetail;
	}

	public void setSubjectDetail(String subjectDetail) {
		this.subjectDetail = subjectDetail;
	}

	public String getSubjectIntroContents() {
		return subjectIntroContents;
	}

	public void setSubjectIntroContents(String subjectIntroContents) {
		this.subjectIntroContents = subjectIntroContents;
	}

	
}
