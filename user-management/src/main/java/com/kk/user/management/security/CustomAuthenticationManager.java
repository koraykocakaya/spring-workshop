package com.kk.user.management.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.kk.user.management.entity.User;

@Component
public class CustomAuthenticationManager {

	public boolean customerIdMatches(Authentication authentication, String customerId) {
		User user = (User) authentication.getPrincipal();
		if(user.getCustomer() != null)
			return customerId.equals(user.getCustomer().getId());

		return false;
	}
}
