package com.SpringBoot.SpringMVCSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class DemoSecurityController {
	
	@GetMapping("/hello")
	public String showHello() {
		
		return "home";
	}
	
	@GetMapping("/showMyLoginPage")
	public String showLogin() {
		return "login-form";
	}

}
