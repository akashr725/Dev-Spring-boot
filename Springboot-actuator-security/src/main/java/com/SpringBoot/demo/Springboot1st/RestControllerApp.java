package com.SpringBoot.demo.Springboot1st;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestControllerApp {
	
	
	@GetMapping("/")
	public String sayHello() {
		
		return "Hellow World";
	}
	
	@GetMapping("/name")
	public String sayName() {
		
		return "Hellow Akash";
	}

}
