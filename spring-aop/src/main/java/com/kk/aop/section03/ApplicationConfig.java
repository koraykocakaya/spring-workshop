package com.kk.aop.section03;

import com.kk.aop.section03.bean.Student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.kk.aop.section03.aspect")
@EnableAspectJAutoProxy
public class ApplicationConfig {
	
	@Bean
	public Student getStudent() {
		return new Student("Koray", null);
	}
}
