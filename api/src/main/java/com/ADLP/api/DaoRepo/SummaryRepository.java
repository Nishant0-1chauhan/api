package com.ADLP.api.DaoRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ADLP.api.model.Summary;

@Repository
public interface SummaryRepository extends MongoRepository<Summary, String> {	
	

//	@Query(value = "{ $and:[ { start_timestamp : {$gte:?0},{$lt:?1}  } ] }")
//	
//	Summary findSummaryById();
	
	
	
	
	
	
	
	
}
