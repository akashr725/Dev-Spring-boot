package com.SpringBoot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.utill.Coach;

@RestController
public class DemoCoachController {
	
	private Coach coach;
	
	@Autowired
	public DemoCoachController( @Qualifier("hockey") Coach coach) {
		
		this.coach=coach;
		
	}
	
	@GetMapping("/getday")
	public String getPractieceMassege() {
		
		return coach.getPractiece();
	}
	

}
