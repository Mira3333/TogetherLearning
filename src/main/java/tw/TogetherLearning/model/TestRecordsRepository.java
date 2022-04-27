package tw.TogetherLearning.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TestRecordsRepository extends JpaRepository<TestRecords, Integer> {

	public TestRecords findByStudentId(int studentId);
	
	public TestRecords findById(int testRecordId);

}
