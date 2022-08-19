package com.kk.rest.webservices.springbootworkshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 1. Bu exception throw edildiginde Status Code NOT_FOUND (404) olmasi icin @ResponseStatus eklendi
 * @author korayk
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
	
}
