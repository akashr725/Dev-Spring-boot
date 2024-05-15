package com.HibernateJPA.SpringbooHibernateJPAdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.HibernateJPA.SpringbooHibernateJPAdemo.dao.StudentDao;
import com.HibernateJPA.entity.Student;

@SpringBootApplication()

@EntityScan(
		basePackages = {"com.HibernateJPA.entity"}
		)
public class SpringbooHibernateJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbooHibernateJpaDemoApplication.class, args);
	}
	
	@Bean
	
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		
		return runner->{
			
			//createStudent(studentDao);
			//readStudent(studentDao);
			
			//readAllStudent(studentDao);
			
			//readAllStudentByFirstName(studentDao);
			
			//updateFirstName(studentDao);
			
			deleteEntity(studentDao);
		};
		
	}
	
	private void deleteEntity(StudentDao studentDao) {
		
		int id=4;
		
		boolean delete=studentDao.delete(id);
		
		if(delete) {
			
			System.out.println("Successfully Deleted...........");
		}
		else {
			System.out.println("Something Wrong here............");
		}
		
	}

	private void updateFirstName(StudentDao studentDao) {
		
		// Retrieve Student by id
		
		      int id=1;
		
		      Student student =studentDao.readById(id);
		      
		      System.out.println("Details before Updating: "+student);
		      
		  // Change firstName 
		      
		      System.out.println("Updating Student.................");
		      
		      student.setFirstName("Jhonny");
		      
		      // Update Student
		      
		      studentDao.update(student);
		      
		      // See after updating
		      
		      System.out.println("Details before Updating: "+student);
		
	}

	private void readAllStudentByFirstName(StudentDao studentDao) {
		
		List<Student> student=studentDao.findByFirstNmae("akash");
		
		for(Student dao: student) {
			
			System.out.println(dao);
		}
		
	}

	private void readAllStudent(StudentDao studentDao) {
		
		List<Student> studentList=studentDao.findAll();
		
		for(Student dao:studentList) {
			
			System.out.println(dao);
			
			
		}
		
	}

	private void readStudent(StudentDao studentDao) {
		
		
		Student student=studentDao.readById(5);
		
		System.out.println("Details of student: "+ student);
		
	}

	private void createStudent(StudentDao studentDao) {
		
		// Create Student Object
		
		System.out.println("Creating Student Object..........");
		
		Student student1=new Student("Jhon","Poul","jhon@gmail.com");
		Student student2=new Student("Carlie","Devan","carlie@gmail.com");
		Student student3=new Student("Tony","Stark","tony@gmail.com");
		Student student4=new Student("Doctor","Strange","doctor@gmail.com");
		Student student5=new Student("Captain","America","captain@gmail.com");
		
		//save the object
		
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
		studentDao.save(student4);
		studentDao.save(student5);
		//display the id
		
		System.out.println("Save student Generated Id: " + student1.getId());
	}

}
