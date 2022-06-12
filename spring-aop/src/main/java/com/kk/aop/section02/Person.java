package com.kk.aop.section02;

public class Person {

	private String name;
	private int age;
	
	public int getAge() {
		System.out.println("Age is : " + age);
		return age;
	}
	
	public String getName() {
		System.out.println("Name is : " + name);
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
