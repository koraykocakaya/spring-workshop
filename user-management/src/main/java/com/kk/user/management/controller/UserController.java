package com.kk.user.management.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kk.user.management.entity.User;
import com.kk.user.management.repository.UserRepository;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserRepository userRepository;
	private final GoogleAuthenticator googleAuthenticator;
	
	private User getUser() {
		return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@GetMapping("/user/register2Fa")
	public String register2Fa() {
		User user = getUser();
		String url = GoogleAuthenticatorQRGenerator.getOtpAuthURL("admin", 
				user.getUsername(), 
				googleAuthenticator.createCredentials(user.getUsername()));
		
		log.debug("Google QR URL: " + url);
		
		return url;
		
	}
	
	@GetMapping("/user/confirm2Fa")
	public String confirm2Fa(@RequestParam("verifyCode") Integer verifyCode) {
		User user = getUser();
		
		log.debug("Authenticating with: " + verifyCode);
		
		if(googleAuthenticator.authorizeUser(user.getUsername(), verifyCode)) {
			User savedUser = userRepository.findById(user.getId()).orElseThrow();
			savedUser.setUserGoogle2fa(true);
			userRepository.save(savedUser);
			return "OK";
		} else {
			return "NOT OK";
		}
	}
	
}
