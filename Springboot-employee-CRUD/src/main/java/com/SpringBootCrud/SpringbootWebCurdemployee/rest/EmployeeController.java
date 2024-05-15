package com.SpringBootCrud.SpringbootWebCurdemployee.rest;

import java.util.List;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;
import com.SpringBootCrud.SpringbootWebCurdemployee.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		
		this.service=service;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		List<Employee> theEmployee=service.findAll();
		
		theModel.addAttribute("employee",theEmployee);
	
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		
		Employee theEmployee=new Employee();
		
		theModel.addAttribute("employee",theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmployee,
			BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			
//			System.out.println("Not Saved.......");
			
			return "employee-form";
		}
		else {
			service.save(theEmployee);
			
//			System.out.println("saved...........");
			
			return "redirect:/employees/list";
		}	
	}
	
	@GetMapping("/showFormForUpdate")
	
	public String formUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		Employee theEmployee=service.findById(theId);
		
		theModel.addAttribute("employee",theEmployee);
		
		return "employee-form";
		
	}
	
	@GetMapping("/delete")
	public String getDelete(@RequestParam("employeeId") int theId) {
		
		service.delete(theId);
		
		return "redirect:/employees/list";
	}

}
