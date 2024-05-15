package com.HibernateJPA.SpringbooHibernateJPAdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HibernateJPA.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	// Create EntityManager field
	
	private EntityManager entityManager;
	
	// Create Constructor for dependency injection
	
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		
		entityManager.persist(student);	
	}

	@Override
	public Student readById(Integer id) {
		
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuary=entityManager.createQuery("FROM Student", Student.class);
		return theQuary.getResultList();
	}

	@Override
	public List<Student> findByFirstNmae(String quary) {
		
		TypedQuery<Student> theQuary=entityManager.createQuery("FROM Student WHERE firstName=:theData", Student.class);
		
		theQuary.setParameter("theData", quary);
		
		return theQuary.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		
		
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		
		Student student=entityManager.find(Student.class, id);
		
		entityManager.remove(student);
		
		return true;
	}


}
