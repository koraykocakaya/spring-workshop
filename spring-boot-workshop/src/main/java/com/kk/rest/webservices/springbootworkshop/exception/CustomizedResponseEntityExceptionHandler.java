package com.kk.rest.webservices.springbootworkshop.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 1. Tum exceptionlarda Springin standart response'u yerine 
 *  custom bir response donebilmek icin ResponseEntityExceptionHandler extend eden bir Handler yarattik
 * 2. Burada ResponseEntity return eden metoda @ExceptionHandler(Exception.class) ekledik ve bu sekilde hata alan tum responselar bunun uzerinden yaratildi
 * 3. Burada kullanilan @ControllerAdvice tum controllerlar icin kullanilmasi icin eklendi
 * 4. Ek olarak tek bir Exception icin de ayri metot yardimiyla donecek ResponseEntity degistirilebilmektedir
 * 5. Validation icin de handleMethodArgumentNotValid bulunmaktadir, ancak daha detayli bir response verebilmek icin
 *  bu metodu Override edip, aciklayici response donecek sekilde gelistirme yapilabilmektedir
 * @author korayk
 */
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		ExceptionResponse response = new ExceptionResponse(new Date(), "Validation error", ex.getBindingResult().toString()); 
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
}
