package com.SpringbootRest.demo.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.SpringbootRest.demo.Entity.StudentErrorResponse;
import com.SpringbootRest.demo.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentRestGlobalExceptionController {
	
	

	// exception handlar 
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> getResponse(StudentNotFoundException exc){
		
		StudentErrorResponse error=new StudentErrorResponse();
		
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setMassege(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler to catch all type of exception
	
	@ExceptionHandler
	
	public ResponseEntity<StudentErrorResponse> getAllResponse(Exception exc){
		
		StudentErrorResponse error=new StudentErrorResponse();
		
		error.setCode(HttpStatus.BAD_REQUEST.value());
		
		error.setMassege(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
