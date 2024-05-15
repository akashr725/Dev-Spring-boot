package com.SpringBootCrud.SpringbootWebCurdemployee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	// Create entity manager field
	
	private EntityManager entityManager;
	
	// create Contructor injection of entitymanager
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		
		this.entityManager=entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// create Quary
		
		TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
		
		// set result is Employee List
		
		List<Employee> result=theQuery.getResultList();
		
		return result;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee employee=entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		
		Employee emp=entityManager.merge(theEmployee);
		
		return emp;
	}

	@Override
	public void delete(int theId) {
		
		Employee emp=entityManager.find(Employee.class, theId);
		
		entityManager.remove(emp);
		
	}

}
