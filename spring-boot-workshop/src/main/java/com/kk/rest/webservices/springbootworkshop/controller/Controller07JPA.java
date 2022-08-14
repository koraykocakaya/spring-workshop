package com.kk.rest.webservices.springbootworkshop.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.kk.rest.webservices.springbootworkshop.exception.UserNotFoundException;
import com.kk.rest.webservices.springbootworkshop.model.Post;
import com.kk.rest.webservices.springbootworkshop.model.User;
import com.kk.rest.webservices.springbootworkshop.repository.PostRepository;
import com.kk.rest.webservices.springbootworkshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * 1. JPA ile ilgili olarak detay veriler application.properties dosyasi uzerinden verilebilmektedir,
 *  Hangi db vs gibi, Burada H2 in-memory db kullanilmaktadir, bu temp db gibi dusunebiliriz
 * 2. Burada table, constraint vs otomatik olsutuktan sonra data.sql dosyasini otomatik calistirilmaktadir
 * 3. 
 * @author korayk
 */
@RestController
public class Controller07JPA {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping ("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll(); 
	}
	
	@GetMapping ("/jpa/users/{id}")
	public User retrieveUser(@PathVariable (name = "id") int id){
		User user = userRepository.findById(id).get();
		if(user == null)
			throw new UserNotFoundException("id: " + id);
		return user;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI uriLoc = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(uriLoc).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userRepository.findById(id).get();
		
		if(user == null)
			throw new UserNotFoundException("id: " + id);
		userRepository.delete(user);
		
	}
	
	@GetMapping ("/jpa/users/{id}/posts")
	public List<Post> retrievePosts(@PathVariable (name = "id") int id){
		User user = userRepository.findById(id).get();
		
		if(user == null)
			throw new UserNotFoundException("id: " + id);
		return user.getPosts();
	}
	
	@PostMapping ("/jpa/users/{id}/posts")
	public Post savePost(@PathVariable (name = "id") int id, @RequestBody Post post){
		User user = userRepository.findById(id).get();
		
		if(user == null)
			throw new UserNotFoundException("id: " + id);
		
		post.setUser(user);
		return postRepository.save(post);
	}
}
