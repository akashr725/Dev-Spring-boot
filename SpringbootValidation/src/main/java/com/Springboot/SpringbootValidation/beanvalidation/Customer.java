package com.Springboot.SpringbootValidation.beanvalidation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@Min(value = 0, message = "enter more than or equal 0")
	@Max(value = 10, message = "enter less than or equal 10")
	private int putNumber;
	
	public Customer() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPutNumber() {
		return putNumber;
	}

	public void setPutNumber(int putNumber) {
		this.putNumber = putNumber;
	}
	
	
	

}
