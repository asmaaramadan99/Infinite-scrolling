package demo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import demo.entity.Employee;

@Component
public class RestTemplateService {
	
	  @Autowired
	
	    private RestTemplate restTemplate;

	  @EventListener(ApplicationReadyEvent.class)
	    public Employee getEmployee() {
		ResponseEntity<Employee> resp = 
	          restTemplate.getForEntity("http://localhost:8080/" + "1", Employee.class);
	     System.out.print(resp.getStatusCodeValue());   
		return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
	    }
	  
	   private Map<String,String> intializeEmployee(String firstname,String lastname,String deparatment){
		   Map<String, String> map = new HashMap<>();
			  map.put("firstname", firstname);
			  map.put("lastname", lastname);
			  map.put("departement", deparatment);
			  return map;
	   }
	  
	  @EventListener(ApplicationReadyEvent.class)
	    public Employee postEmployee() {
		
         Map<String, String> map = intializeEmployee("ASMAA","RAMADAN","Computer science");  
		ResponseEntity<Employee> resp = 
	          restTemplate.postForEntity("http://localhost:8080/add", map, Employee.class);
		if (resp.getStatusCode() == HttpStatus.OK) {
		    System.out.println("Request Successful");
		}
		return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
	    }
	  
	  
	  
}
