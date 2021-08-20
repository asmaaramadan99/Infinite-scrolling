package demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Employee;
import demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee getByID(Long id)
	{
		Employee e = employeeRepository.findById(id).orElse(null);
		return e;
	}
	
	public void addEmployee(Employee e)
	{
		employeeRepository.save(e);
	}
	
	public List<Employee> getAllEmployees(Integer page)
	{
		 //get page by page
	        List<Employee> list= new ArrayList();
	        int startIndex = (page-1)*15;
	        for(int i=startIndex+1;i<startIndex+16;i++) {
	        	Employee e = employeeRepository.findById((long) i).orElse(null);
	        	if(e!=null)
	        	list.add(e);
	        }
	        return list;
	     
	
	}
	
}
