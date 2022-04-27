package tw.TogetherLearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

@Entity	@Table(name = "tutors")
@Component
public class Tutors {
	
	@Id @Column(name = "TUTOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GenericGenerator(name="generator",strategy = "foreign",parameters = @Parameter(name = "property",value = "tutorId"))
	private int tutorId;
	
	@Column(name = "TUTOR_NAME")
	private String tutorName;
	
	@Column(name = "TUTOR_GENDER")
	private int tutorGender;
	
	@Column(name = "TUTOR_EDU")
	private String tutorEdu;
	
	@Column(name = "TUTOR_EXP")
	private String tutorExp;
	
	@Column(name = "MEETING_URL")
	private String meetingUrl;
	
	
	//關連到Courses裡面的tutors物件
	@OneToOne(mappedBy = "tutors",fetch=FetchType.LAZY)
	private Courses courses;

	
	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public int getTutorGender() {
		return tutorGender;
	}

	public void setTutorGender(int tutorGender) {
		this.tutorGender = tutorGender;
	}

	public String getTutorEdu() {
		return tutorEdu;
	}

	public void setTutorEdu(String tutorEdu) {
		this.tutorEdu = tutorEdu;
	}

	public String getTutorExp() {
		return tutorExp;
	}

	public void setTutorExp(String tutorExp) {
		this.tutorExp = tutorExp;
	}

	public String getMeetingUrl() {
		return meetingUrl;
	}

	public void setMeetingUrl(String meetingUrl) {
		this.meetingUrl = meetingUrl;
	}
	
	
	
}
