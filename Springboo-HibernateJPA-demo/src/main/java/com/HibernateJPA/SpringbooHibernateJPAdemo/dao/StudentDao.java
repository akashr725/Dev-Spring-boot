package com.HibernateJPA.SpringbooHibernateJPAdemo.dao;

import java.util.List;

import com.HibernateJPA.entity.Student;

public interface StudentDao {
	
	public void save(Student student);
	
	public Student readById(Integer id);
	
	public List<Student> findAll();
	
	public List<Student> findByFirstNmae( String quary);
	
	public void update(Student student);
	
	public boolean delete(Integer id);

}
