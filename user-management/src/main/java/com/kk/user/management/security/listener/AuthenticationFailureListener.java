package com.kk.user.management.security.listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.kk.user.management.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationFailureListener {

	@EventListener
	public void failure(AuthenticationFailureBadCredentialsEvent event) {
		log.debug("AUTHENTICATION FAILED");
		
		
		if(event.getSource() instanceof UsernamePasswordAuthenticationToken) {
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)event.getSource();
			
			if(token.getPrincipal() instanceof String) {
				String username = (String) token.getPrincipal();
				log.debug(username  + " failed");
			}
			
			if(token.getDetails() instanceof WebAuthenticationDetails) {
				WebAuthenticationDetails details = (WebAuthenticationDetails) token.getDetails();
				
				log.debug("IP Address: " + details.getRemoteAddress());
			}
		}
	}
}
