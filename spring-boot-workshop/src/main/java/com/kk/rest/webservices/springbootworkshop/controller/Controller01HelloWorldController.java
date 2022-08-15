package com.kk.rest.webservices.springbootworkshop.controller;

import com.kk.rest.webservices.springbootworkshop.model.HelloWorldBean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. Burada classi RestController olacak sekilde isaretledik
 * 2. RequestMapping'de URI icin /hello-world vererek localhost:8080/hello-world ile 
 *  GET istegi geldiginde ilgili String donecek sekilde ayarlamis olduk
 * 3. Direkt @GetMapping ile methodu da verebiliriz
 * 4. Direkt bir obje de donebiliriz burada JSON tipinde objeyi donecektir 
 *  ayrica bu noktada objede getterlarin olmasi onemli olackatir, bu ornekte de getMessage metodu olmasa hata atacaktir
 * 5. Spring bootta da arka planda dispatcher servlet calismakta ve bu mapping vs. islemlerini handle etmekte
 * 6. PathVariable ile istege parametre gecilebilmektedir, burada da id ile gelen variable name'e setlenecek sekilde gelistirme yapildi
 * 
  * @author korayk
 */
@RestController
public class Controller01HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World2";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{id}")
	public String helloWorldPathVariable(@PathVariable(name = "id") String  name) {
		return "Hello " + name;
	}
}
