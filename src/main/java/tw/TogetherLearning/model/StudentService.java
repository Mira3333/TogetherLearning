package tw.TogetherLearning.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository stuRep;
	
	
	public Student update(Student student) {
		return stuRep.save(student);
	}

	
	
}
