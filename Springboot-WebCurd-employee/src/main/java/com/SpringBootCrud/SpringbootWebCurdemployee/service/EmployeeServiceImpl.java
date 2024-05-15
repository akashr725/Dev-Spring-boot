package com.SpringBootCrud.SpringbootWebCurdemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBootCrud.SpringbootWebCurdemployee.dao.EmployeeDao;
import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	// create dao field
	
	private EmployeeDao dao;
	
	// create constructor injection
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao dao) {
		
		this.dao=dao;
	}
	
	

	@Override
	public List<Employee> findAll() {
		
		return dao.findAll();
	}



	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return dao.findById(theId);
	}



	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		
		return dao.save(theEmployee);
	}



	@Override
	@Transactional
	public void delete(int theId) {
		
		dao.delete(theId);
		
	}

}
