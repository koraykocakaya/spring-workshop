package com.kk.rest.webservices.springbootworkshop.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.kk.rest.webservices.springbootworkshop.exception.UserNotFoundException;
import com.kk.rest.webservices.springbootworkshop.model.User;
import com.kk.rest.webservices.springbootworkshop.service.UserDAOService;


/**
 * 1. Response olarak ana bilgilerl birlikte bazi linkler de gonderebilmemiz gerekmektedir
 * 2. Bunun icin HATEOAS kullainlabilmektedir, burada da User yerine EntityModel<User> return ederek bunu implement edecegiz
 * 3. Burada link icin WebMvcLinkBuilder ile linkin hangi metot uzerinde oldugu yaratilip response'ta parametre olarak gecmek yeterli olacaktir
 * 4. Bu sekilde static islem vs. yapmadan linkleri de response ile beraber gonderebiliriz
 * 5. Ayrica internationalization (i18n) iselmi de kullanilmaktadir, yani farkli diller icin farkli responselar donebilmekteyiz
 * 6. Burada message_tr.properties gibi dillere gore message dosyalari yaratip, onları messageSource'u Autowired ederek kullanabilmekteyiz
 * 7. helloWorldIntn orneginde de Accept-Langugage headerini alip ona gore ilgili properties dosyasindan okuyacak sekilde gelistirme yapildi
 * 8. Locale'i parametre olarak gecmemek icin  LocaleContextHolder.getLocale() da direkt kullanilabilmektedir
 * 9. Response standartta JSON gonderilmektedir ancak request headerinda Accept'i farkli (application/xml gibi) gondererek farkli tipte response alinabilmektedir
 *  Buna content negotiation denilmektedir
 * @author korayk
 */
@RestController
public class Controller03UserHateoasController {

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	UserDAOService userDAOService;
	
	@GetMapping ("/usersHateoas")
	public List<User> retrieveAllUsers(){
		return userDAOService.findAll(); 
	}
	
	@GetMapping ("/usersHateoas/{id}")
	public EntityModel<User> retrieveUser(@PathVariable (name = "id") int id){
		User user = userDAOService.findById(id);
		if(user == null)
			throw new UserNotFoundException("id: " + id);
		
		WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		
		EntityModel<User> model = EntityModel.of(user, linkToUsers.withRel("all-users")); 
		return model;
	}
	
	@GetMapping("/hello-world-intn")
	public String helloWorldIntn(
			@RequestHeader(required = false, name = "Accept-Language") Locale locale
			) {
//																						LocaleContextHolder.getLocale()																				
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
																						
	}
	
}
