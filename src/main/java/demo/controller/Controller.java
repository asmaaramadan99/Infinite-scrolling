package demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Employee;
import demo.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class Controller {
    
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable (name = "id") long id)
	{
		return employeeService.getByID(id);
	}
	
    @PostMapping("/add")
    public void addEmployee(@RequestBody Map<String ,Object> employeeInfo)
    {
    	Employee e = new Employee();
    	e.setFirstName((String)employeeInfo.get("firstname"));
    	e.setLastName((String)employeeInfo.get("lastname"));
    	e.setDepartement((String)employeeInfo.get("departement"));
    	employeeService.addEmployee(e);
    }
    
    @GetMapping("/getAll/{page}")
    public List<Employee> getAllEmployees(@PathVariable (name= "page") Integer page)
    {
    	
		return employeeService.getAllEmployees( page);
    	
    }
	

}
