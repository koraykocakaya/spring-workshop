package com.kk.controller.section03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView view = new ModelAndView("testExample");
		view.addObject("testMessage", "Test Message");
		return view;
	}
}
