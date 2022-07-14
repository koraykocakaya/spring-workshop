package com.kk.controller.section03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 1. SimpleUrlHandlerMapping olarak kullanildi, servlet dosyasinda urlHandler1.htm pathinden gelen istekler buraya yonlendirildi
 * @author korayk
 *
 */
public class UrlHandlerController1 extends AbstractController {
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView view = new ModelAndView("urlHandlerExample");
		view.addObject("message", "URL Handler 1");
		return view;
	}
}
