package tw.TogetherLearning.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestRecordsService {
	
	@Autowired
	private TestRecordsRepository trRep;		
	
	
//--------------------------------------新增選課-------------------------------------------	
	public TestRecords insert(TestRecords testRecord) {
		return trRep.save(testRecord);		
	}
	

	
}
