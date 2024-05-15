package com.SpringBootCrud.SpringbootWebCurdemployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootCrud.SpringbootWebCurdemployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
