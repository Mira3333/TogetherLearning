package tw.TogetherLearning.model;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PointsService {
	
	@Autowired
	private PointsRepository pRep;
	
//--------------------------------------新增點數異動紀錄-------------------------------------------	
	public PointRecords insert(PointRecords points) {
		return pRep.save(points);		
	}
	

}
