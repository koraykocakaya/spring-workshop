package com.kk.user.management.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails ud = User.withDefaultPasswordEncoder()
							 .username("Koray")
							 .password("12")
							 .roles("ADMIN")
							 .build();
		return ud;
	}
}
