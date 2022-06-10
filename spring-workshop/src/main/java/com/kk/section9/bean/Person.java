package com.kk.section9.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("prototype")
public class Person {

	public Person() {
		System.out.println("Person constructor called");
	}
	
	public String getName() {
		return "Person1";
	}
}
