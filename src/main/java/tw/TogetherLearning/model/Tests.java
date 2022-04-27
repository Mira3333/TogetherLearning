package tw.TogetherLearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity	@Table(name = "tests")
@Component
public class Tests {
	
	@Id @Column(name = "TEST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;
	
	@Column(name = "TEST_SUBJECT_ID")
	private int testSubjectId;

	@Column(name = "TEST_NAME")
	private String testName;
	
	@Column(name = "TEST_DURATION")
	private int testDuration;
	
	@Column(name = "TEST_REQUIRED_POINTS")
	private int testRequiredPoints;
	
	@Column(name = "TEST_PHOTO")
	private String testPhoto;
	
	@Column(name = "TEST_INTRO_CONTENTS")
	private String testIntroContents;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "test_subject_id", insertable = false, updatable = false)
	private TestSubjects testSubjects;
	

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getTestSubjectId() {
		return testSubjectId;
	}

	public void setTestSubjectId(int testSubjectId) {
		this.testSubjectId = testSubjectId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}

	public int getTestRequiredPoints() {
		return testRequiredPoints;
	}

	public void setTestRequiredPoints(int testRequiredPoints) {
		this.testRequiredPoints = testRequiredPoints;
	}

	public String getTestPhoto() {
		return testPhoto;
	}

	public void setTestPhoto(String testPhoto) {
		this.testPhoto = testPhoto;
	}

	public String getTestIntroContents() {
		return testIntroContents;
	}

	public void setTestIntroContents(String testIntroContents) {
		this.testIntroContents = testIntroContents;
	}

	public TestSubjects getTestSubjects() {
		return testSubjects;
	}

	public void setTestSubjects(TestSubjects testSubjects) {
		this.testSubjects = testSubjects;
	}
	
	
	
}
