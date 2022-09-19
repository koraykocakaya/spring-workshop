package com.kk.user.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 * @author korayk
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		System.out.println("Filter Chain ");
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.and()
//			.httpBasic();
		http.authorizeRequests(authorize -> {
			authorize.antMatchers("/hello").permitAll()
					 .mvcMatchers(HttpMethod.GET, "/hello-auth").permitAll();
		}).authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();

	    return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		System.out.println("User details called");
		UserDetails ud = User.withDefaultPasswordEncoder()
				 .username("Koray")
				 .password("12")
				 .roles("ADMIN")
				 .build();
		
		return new InMemoryUserDetailsManager(ud);
	}
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		System.out.println("Filter Chain 2");
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.and()
//			.httpBasic();
//		
//	    return http.build();
//	}

}
