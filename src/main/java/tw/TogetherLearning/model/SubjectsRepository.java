package tw.TogetherLearning.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {

	public Subjects findBySubjectId(int SubjectId);

}
