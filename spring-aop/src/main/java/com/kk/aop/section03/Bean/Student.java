package com.kk.aop.section03.Bean;

public class Student {

	private String name;
	private String schoolName;
	
	public Student() {
		
	}
	
	public Student(String name, String schoolName) {
		super();
		this.name = name;
		this.schoolName = schoolName;
	}

	public String getName() {
		return name;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void getError() throws IllegalArgumentException {
		throw new IllegalArgumentException("Hata");
	}
	
}
