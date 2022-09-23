package com.kk.user.management.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

public class RestParamAuthFilter extends AbstractRestAuthFilter {

	public RestParamAuthFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}
	
	@Override
	protected String getUsername(HttpServletRequest request) {
		return request.getParameter("Api-key");
	}
	
	@Override
	protected String getPassword(HttpServletRequest request) {
		return request.getParameter("Api-secret");
	}
}
