package com.kk.user.management.security.listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationSuccessListenerCopy {

	@EventListener
	public void listenSuccess(AuthenticationSuccessEvent event) {
		log.debug("User successfully logged in: " + event.getAuthentication().getName() + " - COPY");
	}
}
