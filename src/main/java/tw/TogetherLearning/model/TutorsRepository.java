package tw.TogetherLearning.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorsRepository extends JpaRepository<Tutors, Integer> {

	public Tutors findByTutorId(int TutorId);
	
	

}
