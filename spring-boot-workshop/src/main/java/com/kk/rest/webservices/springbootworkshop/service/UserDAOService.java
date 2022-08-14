package com.kk.rest.webservices.springbootworkshop.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import com.kk.rest.webservices.springbootworkshop.exception.UserNotFoundException;
import com.kk.rest.webservices.springbootworkshop.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserDAOService {

	private static List<User> users = new ArrayList<>();
	private static int total = 3;
	
	static {
		users.add(new User("Koray", 1, new Date()));
		users.add(new User("Ahmet", 2, new Date()));
		users.add(new User("Ayse", 3, new Date()));
	}
	
	public User saveUser(User user) {
		if(user.getId() == null) {
			user.setId(++total);
		}
		users.add(user);
		return user;
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id) {
		return users.stream()
					.filter(x -> x.getId() == id)
					.findFirst()
					.orElse(null);
	}
	
	public User deleteUser(int id) {
		User user = findById(id);
		if(user != null)
			users.remove(user);
		return user;
	}
}
