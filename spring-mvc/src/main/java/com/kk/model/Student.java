package com.kk.model;

import org.hibernate.validator.constraints.Range;

public class Student {

	@Range(min = 1, max = 150)
	private Integer age;
	
	private String name;
	private Integer id;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
