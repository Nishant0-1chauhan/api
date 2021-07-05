package com.ADLP.api.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ADLP.api.model.Summary;



public interface SummaryService {
	
	public List<Summary> getAllEvents();
	
	public Summary addSummary(Summary events);
	
	public Optional<Summary> getEventById(String _id);

	public Map<String, Object> getFieldsInPage(int pageNo, int pageSize, String sortBy);
	
	public List<Summary> getAllByExample(Summary summary);
	
	public Summary getLocation();
	
	public List<Summary> getByQueryMethod(String[] date,String[] point, String max);
	
	public List<Summary> searchbylocation(String lat, String longt, String maxDistance);
}
