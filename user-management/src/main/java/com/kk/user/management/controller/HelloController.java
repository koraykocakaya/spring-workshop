package com.kk.user.management.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello";
	}
	
	@GetMapping("/hello-auth")
	public String helloAuth() {
		return "Hello Auth";
	}
	
	@GetMapping("/hello-login")
	public String helloLogin() {
		return "Hello Login";
	}
	
	@GetMapping("/hello-login-role")
	public String helloLoginRole() {
		return "Hello Login Role";
	}
	
	@GetMapping("/hello-login-admin")
	public String helloLoginOnlyAdmin() {
		return "Hello Login Only Admin";
	}
	
	@GetMapping("/hello-login-admin-customer")
	public String helloLoginOnlyAdminCustomer() {
		return "Hello Login Only Admin and Customer";
	}
	
	@PreAuthorize("hasRole('USER','CUSTOMER')")
//	@Secured(value = {"ROLE_USER", "ROLE_CUSTOMER"})
	@GetMapping("/hello-login-method")
	public String helloLoginMethod() {
		return "Hello Login Method Example";
	}
}
