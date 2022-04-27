package tw.TogetherLearning.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TestQuestionsRepository extends JpaRepository<TestQuestions, Integer> {

	public TestQuestions findByTestQuestionId(int testQuestionId);
	
	public List<TestQuestions> findByTestId(int testId);

}
