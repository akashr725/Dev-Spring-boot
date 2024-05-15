package com.Springboot.thymeleaf.Soringbootthymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Springboot.thymeleaf.Soringbootthymeleafdemo.model.Student;

@Controller
public class StudentController {
	
	//get the countries from properties file
	
	@Value("${countries}")
	private List<String> countries;
	
	//get the favouriteLanguage from properties file
	
	@Value("${favouriteLanguage}")
	private List<String> favouriteLanguage;
	
	//get the checkBox from properties file
	
	@Value("${checkbox}")
	private List<String> checkBox;
	
	
	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {
		
		// Create student object
		
		Student theStudent=new Student();
		
		//create model
		
		theModel.addAttribute("student",theStudent);
		
		// create model for countries
		
		theModel.addAttribute("countries",countries);
		
		// create model for favouriteLanguage
		
		theModel.addAttribute("thefavouriteLanguage",favouriteLanguage);
		
		// create model for checkbox
		
		theModel.addAttribute("thecheckbox",checkBox);
		
		return "student-form";
	}
	
	
	@PostMapping("/processStudentForm")
	public String processStudentForm(@ModelAttribute("student")Student theStudent) {
		
		// print student data in console
		
		System.out.println("The Student: "+ theStudent.getFirstName()+ " " + theStudent.getLastName());
		
		return "student-confirmation";
	}

}
