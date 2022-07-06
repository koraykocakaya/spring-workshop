package com.kk.model;

public class Person {

	private String name;
	private String surname;
	private int age;
	private String country;
	
	public Person() {
		super();
	}
	
	public Person(String name, String surname, int age, String couuntry) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.country = couuntry;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}

