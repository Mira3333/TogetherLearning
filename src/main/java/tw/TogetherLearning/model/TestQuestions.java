package tw.TogetherLearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity	@Table(name = "test_questions")
@Component
public class TestQuestions {
	
	@Id @Column(name = "TEST_QUESTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testQuestionId;
	
	@Column(name = "TEST_ID")
	private int testId;
	
	@Column(name = "QUESTION")
	private String question;
	
	@Column(name = "OPTION_A")
	private String optionA;
	
	@Column(name = "OPTION_B")
	private String optionB;
	
	@Column(name = "OPTION_C")
	private String optionC;
	
	@Column(name = "OPTION_D")
	private String optionD;

	@Column(name = "ANSWER")
	private String answer;

	public int getTestQuestionId() {
		return testQuestionId;
	}

	public void setTestQuestionId(int testQuestionId) {
		this.testQuestionId = testQuestionId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
}
