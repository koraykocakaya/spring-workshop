package com.kk.user.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAuthController {

	@GetMapping("/loginCustomAuth")
	public String getLoginCustomAuth() {
		return "Login Custom Auth";
	}
}
