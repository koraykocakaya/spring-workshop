package com.kk.user.management.security.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.kk.user.management.entity.LoginSuccess;
import com.kk.user.management.entity.User;
import com.kk.user.management.repository.LoginSuccessRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationSuccessListener {

	@Autowired
	private LoginSuccessRepository loginSuccessRepository;
	
	@EventListener
	public void listenSuccess(AuthenticationSuccessEvent event) {
		
		log.error("User successfully logged in");
		if(event.getSource() instanceof UsernamePasswordAuthenticationToken) {
			LoginSuccess.LoginSuccessBuilder builder = LoginSuccess.builder();
			
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)event.getSource();
			
			if(token.getPrincipal() instanceof User) {
				User user = (User) token.getPrincipal();
				builder.user(user);
				log.debug(user.getUsername()  + " logged in the system");
				
			}
			
			if(token.getDetails() instanceof WebAuthenticationDetails) {
				WebAuthenticationDetails details = (WebAuthenticationDetails) token.getDetails();
				
				log.debug("IP Address: " + details.getRemoteAddress());
				builder.sourceIp(details.getRemoteAddress());
			}
			
			LoginSuccess savedLS = loginSuccessRepository.save(builder.build());
			log.debug("Login Success saved with id: " + savedLS.getId());
		}
		
	}
}
