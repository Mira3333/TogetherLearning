package tw.TogetherLearning.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TestSubjectsRepository extends JpaRepository<TestSubjects, Integer> {

	public TestSubjects findByTestSubjectId(int testSubjectId);

}
