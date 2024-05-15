package com.SpringBootCrud.SpringbootWebCurdemployee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;
import com.SpringBootCrud.SpringbootWebCurdemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	// create Dao field
	
	private EmployeeService service;
	
	// setContructor injection
	
	@Autowired
	public EmployeeRestController(EmployeeService service) {
		
		this.service=service;
	}
	
	// create method to find All employee details
	
	@GetMapping("/employees")
	public List<Employee> fidnAllEmployee(){
		
		return service.findAll();
	}
	
	// create method find By id
	
	@GetMapping("/employees/{id}")
	public Employee findByid(@PathVariable int id) {
		
		Employee emp=service.findById(id);
		
		if(emp==null) {
			
			throw new RuntimeException("Employee is not found"+ id);
			
		}
		
		return emp;
	}
	
	
	// add new employee
	
	@PostMapping("/employees")
	public Employee addNewEmployee(
		@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		Employee emp=service.save(theEmployee);
		
		return emp;
		
	}
	
	// update employee details
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee theEmployee) {
		
		Employee emp=service.save(theEmployee);
		
		return emp;
		
	}
	
	// delete employee by id
	
	@DeleteMapping("/employees/{id}")
	public String delete(@PathVariable int id) {
		
		Employee emp=service.findById(id);
		
		if(emp==null) {
			
			throw new RuntimeException("Employee does not Exist in this Id: "+id);
		}
		
		service.delete(id);
		
		return "Employee has been deleted- "+id;
		
	}
	

}
