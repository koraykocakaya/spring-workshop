package com.kk.user.management.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.user.management.config.annotation.Auth2Permission;

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
	
	@PreAuthorize("hasAuthority('auth3')")
	@GetMapping("/hello-login-admin")
	public String helloLoginOnlyAdmin() {
		return "Hello Login Only Admin";
	}
	
	@Auth2Permission
	@GetMapping("/hello-login-admin-customer")
	public String helloLoginOnlyAdminCustomer() {
		return "Hello Login Only Admin and Customer";
	}
	
	@PreAuthorize("hasAuthority('auth1')")
	@GetMapping("/hello-login-method")
	public String helloLoginMethod() {
		return "Hello Login Method Example";
	}
}
