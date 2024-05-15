package com.Springboot.thymeleaf.Soringbootthymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	// Controller method define the html form
	
	@RequestMapping("/showform")
	public String showForm() {
		
		return "helloworld-form";
	}
	
	// COntroller method to see the action of html form
	
	@RequestMapping("/processform")
	public String processForm() {
		
		return "HelloWorld";
	}
	
	@RequestMapping("/processform2")
	
	public String processForm2( HttpServletRequest request, Model model) {
		
		// get the data from html form
		
		String theData=request.getParameter("studentForm");
		
		// convert to upper case
		
		theData=theData.toUpperCase();
		
		// take a result field for model
		
		String result="Yoo! "+theData;
		
		// send it to model 
		
		model.addAttribute("message",result);
		
		
		return "HelloWorld";
	}
	
	@RequestMapping("/processform3")
	
	public String processForm3(@RequestParam("studentForm")String theData, Model model) {
		
		// get the data from html form
		
		//String theData=request.getParameter("studentForm");
		
		// convert to upper case
		
		theData=theData.toUpperCase();
		
		// take a result field for model
		
		String result="Yoo! "+theData;
		
		// send it to model 
		
		model.addAttribute("message",result);
		
		
		return "HelloWorld";
	}

}
