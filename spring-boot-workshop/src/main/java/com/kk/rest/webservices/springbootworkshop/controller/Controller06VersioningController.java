package com.kk.rest.webservices.springbootworkshop.controller;

import com.kk.rest.webservices.springbootworkshop.model.Name;
import com.kk.rest.webservices.springbootworkshop.model.PersonV1;
import com.kk.rest.webservices.springbootworkshop.model.PersonV2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. API'larda farkli verisyonlarda farkli tipler donecek sekilde gelistirme yapilabilmektedir, 
 * bu durumda versiyonlama ihtiyaci olacaktir
 *  1.1 Direkt url uzerinde v1/person gibi verilebilir
 *  1.2 URL'in sonuna parametre ekleyecek sekilde verilebilmektedir person/param?version=1 gibi
 *  1.3 Header olarak ekleme yapilabilmektedir
 * 2. Bu yontemlerin hepsi aktif kullanilabilmektedir, burada kritik nokta ihtiyaca gore secilmesidir
 * 3. Ornegin ilk iki yontem URL'i artirabilecekken, 3. yontem de direkt browser uzerinden kullanilamayacaktir (veya cache kullanilamayacaktir)
 * 4. 
 * @author korayk
 */
@RestController
public class Controller06VersioningController {

	@GetMapping("/v1/person-version")
	public PersonV1 getPersonV1() {
		return new PersonV1("Koray", "Kocakaya");
	} 
	
	@GetMapping("/v2/person-version")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Koray", "Kocakaya"));
	} 
	
	@GetMapping(path =  "/person/param", params = "version=1")
	public PersonV1 getPersonV1Param() {
		return new PersonV1("Koray", "Kocakaya");
	} 
	
	@GetMapping(path =  "/person/param", params = "version=2")
	public PersonV2 getPersonV2Param() {
		return new PersonV2(new Name("Koray", "Kocakaya"));
	} 
	
	@GetMapping(path =  "/person/header", headers = "X_API_VERSION=1")
	public PersonV1 getPersonV1Header() {
		return new PersonV1("Koray", "Kocakaya");
	} 
	
	@GetMapping(path =  "/person/header", headers = "X_API_VERSION=2")
	public PersonV2 getPersonV2Header() {
		return new PersonV2(new Name("Koray", "Kocakaya"));
	} 
}
