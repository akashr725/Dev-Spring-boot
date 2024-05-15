package com.SpringBootCrud.SpringbootWebCurdemployee.service;

import java.util.List;

import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public Employee save(Employee theEmployee);
	
	public void delete(int theId);

}
