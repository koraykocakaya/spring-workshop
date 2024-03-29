package com.kk.user.management.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

public class RestHeaderAuthFilter extends AbstractRestAuthFilter {

	public RestHeaderAuthFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}
	
	@Override
	protected String getUsername(HttpServletRequest request) {
		return request.getHeader("Api-key");
	}
	
	@Override
	protected String getPassword(HttpServletRequest request) {
		return request.getHeader("Api-secret");
	}
}
