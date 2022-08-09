package com.kk.spring.data.jpa.workshop.service;

import com.kk.spring.data.jpa.workshop.entity.Student;
import com.kk.spring.data.jpa.workshop.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService2 {

	@Autowired
	StudentRepository studentRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveStudent() {
		System.out.println("saveStudent called");
		studentRepository.save(Student.builder().firstName("mehmet2").emailId("mehmetemail@asd12356677888").build());
	}
}
