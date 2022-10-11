package com.kk.section01;

/**
 * 1. Su anki sistemde otomatik olarak default constructor, sonrasinda set metodu cagrilmakta  
 * @author korayk
 */
public class ExampleBean {

	private String name;

	public ExampleBean() {
		System.out.println("ExampleBean constructor called");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("Setter called");
	}
	
	public void init() {
		System.out.println("Init method called");
	}
	
	public void doDestroy() {
		System.out.println("Destroy method called");
	}
}
