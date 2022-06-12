package com.kk.aop.section03;

import com.kk.aop.section03.Bean.Student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.kk.aop.section03.Bean")
@EnableAspectJAutoProxy
public class ApplicationConfig {
	
	@Bean
	public Student getStudent() {
		return new Student("Koray", null);
	}
}
