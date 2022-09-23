package com.kk.user.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAuthController {

	@GetMapping("/loginCustomAuth/{id}")
	public String getLoginCustomAuth(@RequestAttribute (name = "id") String id ) {
		return "Login Custom Auth";
	}
}
