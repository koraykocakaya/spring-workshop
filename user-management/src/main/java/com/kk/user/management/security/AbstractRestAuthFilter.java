package com.kk.user.management.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractRestAuthFilter extends AbstractAuthenticationProcessingFilter{

	
	protected AbstractRestAuthFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}
	
	protected abstract String getUsername(HttpServletRequest request);
	
	protected abstract String getPassword(HttpServletRequest request);

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String username = getUsername(request); //request.getHeader("Api-key");
		String password = getPassword(request); //request.getHeader("Api-secret");

		username = username == null ? "" : username;
		password = password == null ? "" : password;

		log.debug("Authenticating user: " + username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

		if (username.length() > 0) {
			return this.getAuthenticationManager().authenticate(token);
		} else {
			return null;
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
		}

		SecurityContextHolder.getContext().setAuthentication(authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {

		SecurityContextHolder.clearContext();

		response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest customRequest = (HttpServletRequest) request;
		HttpServletResponse customResponse = (HttpServletResponse) response;

		if (logger.isDebugEnabled()) {
			logger.debug("Request is to process authentication");
		}

		try {
			Authentication authenticationResult = attemptAuthentication(customRequest, customResponse);
			if (authenticationResult != null) {
				successfulAuthentication(customRequest, customResponse, chain, authenticationResult);
			} else {
				chain.doFilter(customRequest, customResponse);
			}
		} catch (AuthenticationException e) {
			unsuccessfulAuthentication(customRequest, customResponse, e);
		}
	}
}
