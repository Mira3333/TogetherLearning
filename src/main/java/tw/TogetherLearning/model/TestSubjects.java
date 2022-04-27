package tw.TogetherLearning.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity	@Table(name = "test_subjects")
@Component
public class TestSubjects {
	
	@Id @Column(name = "TEST_SUBJECT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testSubjectId;
	
	@Column(name = "TEST_SUBJECT")
	private String testSubject;
	
	@Column(name = "TEST_SUBJECT_PHOTO")
	private String testSubjectPhoto;
	
	
	//One代表的是class TestSubjects ; Many代表的是class TestSubjects當中的private List<Tests> tests
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "testSubjects")
	private List<Tests> tests;
	

	public int getTestSubjectId() {
		return testSubjectId;
	}

	public void setTestSubjectId(int testSubjectId) {
		this.testSubjectId = testSubjectId;
	}

	public String getTestSubject() {
		return testSubject;
	}

	public void setTestSubject(String testSubject) {
		this.testSubject = testSubject;
	}

	public String getTestSubjectPhoto() {
		return testSubjectPhoto;
	}

	public void setTestSubjectPhoto(String testSubjectPhoto) {
		this.testSubjectPhoto = testSubjectPhoto;
	}

	public List<Tests> getTests() {
		return tests;
	}

	public void setTests(List<Tests> tests) {
		this.tests = tests;
	}
	
	
	
	
	
}
