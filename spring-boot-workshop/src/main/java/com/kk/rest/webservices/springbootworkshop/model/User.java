package com.kk.rest.webservices.springbootworkshop.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Size(min = 3, message = "Name at least 3 chars")
	private String name;

	@Id
	@GeneratedValue
	private Integer id;

	private Date birthDate;

	@OneToMany (mappedBy = "user")
	private List<Post> posts;
	
	public User() {
		super();
	}
	
	public User(String name, Integer id, Date birthDate) {
		super();
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", birthDate=" + birthDate + "]";
	}
	
}
