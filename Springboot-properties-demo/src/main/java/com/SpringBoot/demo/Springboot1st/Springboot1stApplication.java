package com.SpringBoot.demo.Springboot1st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		
		scanBasePackages = {"com.SpringBoot.demo.Springboot1st","com.SpringBoot.rest","com.SpringBoot.utill"}
		
		)

public class Springboot1stApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot1stApplication.class, args);
	}

}
