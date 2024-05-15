package com.SpringBootCrud.SpringbootWebCurdemployee.dao;

import java.util.List;

import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public Employee save(Employee theEmployee);
	
	public void delete(int theId);

}
