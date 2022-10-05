package com.kk.user.management.security.google;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kk.user.management.entity.User;
import com.kk.user.management.repository.UserRepository;
import com.warrenstrange.googleauth.ICredentialRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GoogleCredentialRepository implements ICredentialRepository {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String getSecretKey(String userName) {
		User user = userRepository.findByUsername(userName).orElseThrow();
		String secret = user.getGoogle2FaSecret();
		System.out.println("SECRET KEY: --------------------------- " + secret);
		return secret;
	}

	@Override
	public void saveUserCredentials(String userName, String secretKey, int validationCode, List<Integer> scratchCodes) {
		User user = userRepository.findByUsername(userName).orElseThrow();
		
		user.setGoogle2FaSecret(secretKey);
		user.setUserGoogle2fa(true);
		
		System.out.println("SECRET KEY CREDENTIAL: --------------------------- " + secretKey);
		System.out.println("scratchCodes: --------------------------- " + scratchCodes);
		System.out.println("VALIDATION CODE: --------------------------- " + validationCode);
		
		userRepository.save(user);
	}
	
	
}
