package com.SpringbootRest.demo.Rest;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringbootRest.demo.Entity.Student;
import com.SpringbootRest.demo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	
	List<Student> theStudent;
	
	
	@PostConstruct
	public void load() {
		
           theStudent=new ArrayList<Student>();
		
		theStudent.add(new Student("Akash","Roy"));
		theStudent.add(new Student("Mickey","Mouse"));
		theStudent.add(new Student("Spider","Man"));
		
	}
	
	
	@GetMapping("/student")
	public List<Student> getStudent(){
		 
		
		return theStudent;
	}
	
	
	@GetMapping("/student/{studentId}")
	public Student findStudent(@PathVariable int studentId) {
		
		
		if(studentId>=theStudent.size() || studentId<0) {
			
			throw new StudentNotFoundException("Student Id is not Found: "+studentId);
		}
		
		
		
		return theStudent.get(studentId);
	}


}
