package com.SpringBoot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestControllerApp {
	
	@Value("${team.coach}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String teamInfo() {
		
		return "Coach: "+ coachName + "<br> Team Name: "+teamName;
	}
	
	
	@GetMapping("/")
	public String sayHello() {
		
		return "Hellow World";
	}
	
	@GetMapping("/name")
	public String sayName() {
		
		return "Hellow Akash";
	}

}
