package com.kk.rest.webservices.springbootworkshop.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.kk.rest.webservices.springbootworkshop.exception.UserNotFoundException;
import com.kk.rest.webservices.springbootworkshop.model.User;
import com.kk.rest.webservices.springbootworkshop.service.UserDAOService;

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
 * 1. Burada digerinden farkli olarak PostMapping kullandik, metot User parametresi alacak sekilde yazildi
 *  User'i Request'in bodysinde gonderecegimiz icin @RequestBody olarak isaretledik
 * 2. Postman'dan istek atarken de JSON olarak fieldlari gonderip tip olarak da
 *  application/json sectigimizde maplemede sorun olmadan istegi yapabildik
 * 3. saveUser metodunu ResponseEntity.created donecek sekilde asagidaki gibi yazarsak, 
 *  201 response code'u ile donecektir ve response headera location parametresi ekleyecektir
 * 4. retrieveUser orneginde oldugu gibi kod hata attiginda otomatik 500 kodu gonderilecektir ,
 *  ancak Exceptiona'a ResponseStatus verilebilmektedir, bu ornekte de 404 (Not found) verildigi gibi 
 * 5. Exception durumundaki response'u ayarlamak icin CustomizedResponseEntityExceptionHandler yaratildi
 * 6. Ek olarak inputlara validation da verebilmekteyiz, ornegin save servisinde User'i @Valid ile isaretledik ve 
 *  User classinda da name icin @Size(min=3) verdigimiz icin 3 karakter altinda gelirse direkt 400-Bad Request donecektir 
 * 
 * @author korayk
 */
@RestController()
public class Controller02UserController {

	@Autowired
	UserDAOService userDAOService;
	
	@GetMapping ("/users")
	public List<User> retrieveAllUsers(){
		return userDAOService.findAll(); 
	}
	
	@GetMapping ("/users/{id}")
	public User retrieveUser(@PathVariable (name = "id") int id){
		User user = userDAOService.findById(id);
		if(user == null)
			throw new UserNotFoundException("id: " + id);
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userDAOService.saveUser(user);
		URI uriLoc = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(uriLoc).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User deletedUser = userDAOService.deleteUser(id);
		if(deletedUser == null)
			throw new UserNotFoundException("id: " + id);
		
	}
}
