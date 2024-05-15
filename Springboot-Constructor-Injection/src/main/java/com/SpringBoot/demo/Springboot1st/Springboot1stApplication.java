package com.SpringBoot.demo.Springboot1st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Springboot1stApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot1stApplication.class, args);
	}

}
