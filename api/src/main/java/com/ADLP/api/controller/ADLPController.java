package com.ADLP.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ADLP.api.Service.SummaryService;
import com.ADLP.api.model.Summary;




@RestController 
@RequestMapping("/summary")
public class ADLPController {
	
	
	@Autowired
	SummaryService eveServ;
	
	@GetMapping("/") 
	public List<Summary>  getAll()
	{
		 return this.eveServ.getAllEvents();
	}
	
	@GetMapping("/location")
	public Summary getLocation()
	{
		return this.eveServ.getLocation();
	}
	
	
	@PostMapping("/")
	public Summary addEvent(@RequestBody Summary summary)
	{
		return this.eveServ.addSummary(summary);
	}
	
	@GetMapping("/{_id}")
	public Optional<Summary> getById(@PathVariable String _id)
	{
		return this.eveServ.getEventById(_id);
	}
	
	@GetMapping("/page")
	public Map<String, Object> getAllFieldInPage(@RequestParam(name="pageno",defaultValue = "0") int pageNo,
			@RequestParam(name="pagesize",defaultValue = "2") int pageSize,
			@RequestParam(name="sortby",defaultValue = "id") String sortBy){

		return eveServ.getFieldsInPage(pageNo, pageSize, sortBy);
		
	}
	
	@GetMapping("/example") 
	public List<Summary>  getAllByExample(@RequestBody Summary summary)
	{
		//List<Summary> findAll = adrepo.findAll();
		 return this.eveServ.getAllByExample(summary);
	}
	
	
	@GetMapping("/locationNear/{date1}/{date2}/{lat}/{longt}/{max}")
	public List<Summary> getByDateAndPoint(@PathVariable String date1,@PathVariable String date2, @PathVariable String lat, @PathVariable String longt,@PathVariable String max)//@RequestParam String[] date, @RequestParam String[] point, @RequestParam(name="max",defaultValue="500") String max )
	{
		String date[]=new String[2];
		date[0]=date1;
		date[1]=date2;
		
		String point[]=new String[2];
		point[0]=lat;
		point[1]=longt;
				
		
		return this.eveServ.getByQueryMethod(date,point,max);
		
	}
	
	
	@GetMapping("/byLocation")
	public List<Summary> getByPoint(@RequestParam Date[] date, @RequestParam(name="lat") String lat, @RequestParam(name="longt") String longt, @RequestParam(name="max",defaultValue="500") String max)
	{

		return this.eveServ.searchbylocation(lat, longt, max);
	}
	
	
	
	
}
