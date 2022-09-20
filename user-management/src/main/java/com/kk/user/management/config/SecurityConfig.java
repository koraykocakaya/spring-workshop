package com.kk.user.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.kk.user.management.security.CustomPasswordEncoderFactories;

/**
 * 
 * @author korayk
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig{
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return CustomPasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
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
		UserDetails user1 = User.withUsername("Koray")
				 .password("{ldap}{SSHA}PXU6F6h+35H4Pw7V+v3cjGtVZvKo9G8WPsFMLQ==") // LDAP 12
				 .roles("ADMIN")
				 .build();
		
		
		UserDetails user2 = User.withDefaultPasswordEncoder()
				 .username("admin")
				 .password("1234")
				 .roles("ADMIN")
				 .build();
		
		UserDetails user3 = User.withUsername("KorayB")
				 .password("{hard-bcrypt}$2a$10$NPNBDd8gqOsVCx4KvXbKzu8lP9RSF1GpVKu.ZQlaxVgKb0m/QfyOm") // bcrypt 12, koray custom tanmilandi
				 .roles("ADMIN")
				 .build();
		// $2a$15$gY1aOGRstnC.BKt2ew6O7uxvhT8oWaDUXe6Dj3wFc80bVDpDjbFGK
		return new InMemoryUserDetailsManager(user1, user2, user3);
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
