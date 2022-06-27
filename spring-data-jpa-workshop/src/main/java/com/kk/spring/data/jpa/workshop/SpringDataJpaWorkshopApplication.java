package com.kk.spring.data.jpa.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kk.spring.data.jpa.workshop.entity.Student;

@SpringBootApplication
public class SpringDataJpaWorkshopApplication {

	public static void main(String[] args) {
		Student s = new Student();
		
		SpringApplication.run(SpringDataJpaWorkshopApplication.class, args);
	}

}
