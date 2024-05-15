package com.SpringBootCrud.SpringbootWebCurdemployee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;

@Entity
@Table(name="employee")
public class Employee {
	
	// define fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="firstname")
	@NotNull(message = "is Required")
	@Size(min = 1,message = "is Required")
	private String firstName;
	
	@Column(name="lastname")
	@NotNull(message = "is Required")
	@Size(min = 1,message = "is Required")
	private String lastName;
	
	@Column(name="email")
	@Email(message = "Email is not valid", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags =Flag.CASE_INSENSITIVE)
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
	// define constructor
	
	public Employee() {
		
	}

	public Employee( String firstName, String lastName, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
	// define setter and getter method
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	
	// define toString method
	
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}


}
