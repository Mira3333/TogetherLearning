package tw.TogetherLearning.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TestsRepository extends JpaRepository<Tests, Integer> {

	public Tests findByTestId(int testId);
	
	public List<Tests> findByTestSubjectId(int testSubjectId);

}
