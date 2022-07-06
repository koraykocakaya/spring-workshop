package com.kk.spring.data.jpa.workshop.section02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kk.spring.data.jpa.workshop.entity.Guardian;
import com.kk.spring.data.jpa.workshop.entity.Student;
import com.kk.spring.data.jpa.workshop.repository.StudentRepository;

/**
 * 1. 
 * @author korayk
 *
 */
@SpringBootTest
class EmbeddedEmbadableTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Guardian guardian = Guardian.builder()
									.gEmail("gemail1")
									.name("Guardian name")
									.gMobile("g123456")
									.build();
		
		Student student = Student.builder()
								 .emailId("koraykocakaya@testmail4")
								 .firstName("Koray99")
								 .lastName("Kocakaya3")
								 .guardian(guardian)
								 .build();
				
		studentRepository.save(student);
		 
	}
	
}
