package com.kk.spring.data.jpa.workshop.section04;

import com.kk.spring.data.jpa.workshop.service.StudentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 1. 
 * @author korayk
 */
@SpringBootTest
public class StudentServiceTest {

	@Autowired
	StudentService studentService;
	
	@Test
	void serviceLayerTransactionalCheck() throws Exception {
		studentService.saveStudents();
	}
	
}
