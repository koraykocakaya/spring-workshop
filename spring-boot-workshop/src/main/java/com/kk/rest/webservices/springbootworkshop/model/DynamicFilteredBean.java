package com.kk.rest.webservices.springbootworkshop.model;


import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("DynamicFilteredBeanFilter")
public class DynamicFilteredBean {
	
	private String name;
	private String surname;
	private int age;
	
	public DynamicFilteredBean(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
