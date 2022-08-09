package com.kk.spring.data.jpa.workshop.service;

import java.sql.SQLException;

import javax.transaction.TransactionalException;

import com.kk.spring.data.jpa.workshop.entity.Course;
import com.kk.spring.data.jpa.workshop.entity.Student;
import com.kk.spring.data.jpa.workshop.repository.CourseRepository;
import com.kk.spring.data.jpa.workshop.repository.StudentRepository;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

	@Autowired
	public CourseRepository courseRepository;
	
	@Autowired
	public StudentRepository studentRepository;
	
	@Autowired
	public StudentService2 studentService2;

	@Transactional(noRollbackFor = { Exception.class })
	public void saveStudents()  {
		
		
		courseRepository.save(Course.builder().credit(123444).title("titl12311").courseId(12345454L).build());
		System.out.println("hiiii");
//		studentRepository.save(Student.builder().firstName("Koray123444").emailId("email123454_1111*").build());
//		System.out.println("First saved");
		studentRepository.save(Student.builder().firstName("Koray123444").emailId("koraykocakaya@testmail412_1111*").build());
		studentService2.saveStudent(); 
		
		
		
		
	}
	
}
