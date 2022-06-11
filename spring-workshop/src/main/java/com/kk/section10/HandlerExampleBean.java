package com.kk.section10;

import org.springframework.stereotype.Component;

@Component("beanEx")
public class HandlerExampleBean {

	private String name;
	
	public HandlerExampleBean() {
		System.out.println("HandlerExampleBean constructor called");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
