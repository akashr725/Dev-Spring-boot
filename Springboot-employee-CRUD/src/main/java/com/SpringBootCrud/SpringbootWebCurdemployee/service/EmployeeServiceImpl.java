package com.SpringBootCrud.SpringbootWebCurdemployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.SpringBootCrud.SpringbootWebCurdemployee.dao.EmployeeRepository;
import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;

import jakarta.persistence.EntityManager;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	// create dao field
	
	private EmployeeRepository employee;
	
	// create constructor injection
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employee) {
		
		this.employee=employee;
	}
	
	

	@Override
	public List<Employee> findAll() {
		
		return employee.findAll();
	}



	@Override
	@Transactional
	public Employee findById(int theId) {
		
		Employee emp=null;
		
		Optional<Employee> result=employee.findById(theId);
		
		if(result.isPresent()) {
			
			emp=result.get();
		}
		else {
			
			throw new RuntimeException("Employye Id is not found: "+theId);
		}
		
		return emp;
	}



	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		
		return employee.save(theEmployee);
	}



	@Override
	@Transactional
	public void delete(int theId) {
		
		employee.deleteById(theId);
		
	}

}
