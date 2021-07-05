package com.ADLP.api.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import com.ADLP.api.DaoRepo.SummaryRepository;
import com.ADLP.api.model.Summary;

@Service
public class SummaryServiceImpl implements SummaryService {

	@Autowired
	SummaryRepository adRepo;

	@Override
	public List<Summary> getAllEvents() {

		List<Summary> findAll = adRepo.findAll();

		return findAll;
	}

	@Override
	public Summary addSummary(Summary event) {

		adRepo.insert(event);

		return event;
	}

	@Override
	public Optional<Summary> getEventById(String _id) {

		Optional<Summary> findById = adRepo.findById(_id);

		return findById;
	}

	@Override
	public Map<String, Object> getFieldsInPage(int pageNo, int pageSize, String sortBy) {

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		Sort sort = Sort.by(sortBy);
		Pageable page = PageRequest.of(pageNo, pageSize, sort);

		Page<Summary> summaPage = adRepo.findAll(page);
		response.put("data", summaPage.getContent());
		response.put("Total number of Pages", summaPage.getTotalPages());
		response.put("Total number of current Elements", summaPage.getTotalElements());
		response.put("Current Page number", summaPage.getNumber());
		return response;
	}

	@Override
	public List<Summary> getAllByExample(Summary summary) {
		Example<Summary> e = Example.of(summary);
		return adRepo.findAll(e);
	}

	@Override
	public Summary getLocation() {

		
		
		return null;
	}

	@Autowired
	MongoOperations operations;
	
	
	@Override
	public List<Summary> getByQueryMethod(String[] date, String[] point, String max) {
		
		
		String lat=  point[0];
		String longt= point[1];
		
		String date1=date[0];
		String date2=date[1];
		
		//Point point2=new Point(p1, p2);
		//Distance distance= new Distance(max,Metrics.KILOMETERS);
		BasicQuery query2 = new BasicQuery("{$and: [{start_timestamp : {$gte: "+date1+",$lt: "+date2+"}},{ end_lat_long:{ $near:{ $geometry: {type: 'Point' , coordinates:[ "+lat+", "+longt+" ] }, $maxDistance:"+max+" }}}]}");
	
	
		List<Summary> venues=operations.find(query2,Summary.class);
		return venues;
	}

	   public List<Summary> searchbylocation(String lat, String longt, String maxDistance) {
       
		   BasicQuery query1 = new BasicQuery("{geoLocation:{ $near: { $geometry: { type: 'Point',coordinates: ["+ lat+","+ longt+" ] }, $maxDistance: "+maxDistance+"}}}");
//         BasicQuery query2 = new BasicQuery("{$and: ["{start_timestamp : {"$gte": "+date1+",$lt: "+date2+"}},{ end_lat_long:{ $near:{ $geometry: {type: 'Point' , coordinates:[ "+lat+", "+longt+" ] }, $maxDistance:"+max+" }}}]}");
         
         List<Summary> venues1 = operations.find(query1, Summary.class);

         return venues1;
}
	
	
	
}
