package com.kk.user.management.controller;

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
}
