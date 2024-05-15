package com.SpringBootCrud.SpringbootWebCurdemployee.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;
import com.SpringBootCrud.SpringbootWebCurdemployee.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		
		this.service=service;
	}
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		List<Employee> theEmployee=service.findAll();
		
		theModel.addAttribute("employee",theEmployee);
	
		return "list-employees";
	}

}
