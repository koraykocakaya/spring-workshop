package com.kk.user.management.security.listener;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.kk.user.management.entity.LoginFailure;
import com.kk.user.management.entity.User;
import com.kk.user.management.repository.LoginFailureRepository;
import com.kk.user.management.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationFailureListener {

	@Autowired
	private LoginFailureRepository loginFailureRepository;

	@Autowired
	private UserRepository userRepository;

	@EventListener
	public void failure(AuthenticationFailureBadCredentialsEvent event) {
		log.debug("AUTHENTICATION FAILED");
		
		
		if(event.getSource() instanceof UsernamePasswordAuthenticationToken) {
			LoginFailure.LoginFailureBuilder builder = LoginFailure.builder();
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)event.getSource();
			
			if(token.getPrincipal() instanceof String) {
				String username = (String) token.getPrincipal();
				builder.username(username);
				builder.user(userRepository.findByUsername(username).orElse(null));
				
				log.debug(username  + " failed");
			}
			
			if(token.getDetails() instanceof WebAuthenticationDetails) {
				WebAuthenticationDetails details = (WebAuthenticationDetails) token.getDetails();
				builder.sourceIp(details.getRemoteAddress());
				log.debug("IP Address: " + details.getRemoteAddress());
			}
			
			LoginFailure failed = loginFailureRepository.save(builder.build());
			log.debug("Failed id: " + failed.getId());
			if(failed.getUser() != null) {
				checkAndLockUserAccount(failed.getUser());
			}
		}
	}
	
	private void checkAndLockUserAccount(User user) {
	
		List<LoginFailure> failures = loginFailureRepository.findAllByUserAndCreatedDateIsAfter(user, 
				Timestamp.valueOf(LocalDateTime.now().minusDays(1)));
		
		if(failures.size() > 3) {
			user.setAccountNonLocked(false);
			userRepository.save(user);
			log.debug("User: " + user.getUsername() + " account locked");
		}
				
		
	}
}
