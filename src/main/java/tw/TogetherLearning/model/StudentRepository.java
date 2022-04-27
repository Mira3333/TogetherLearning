package tw.TogetherLearning.model;


import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findBystudentId(int studentId); 
	
}
