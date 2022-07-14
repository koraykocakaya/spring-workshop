package com.kk.controller.section03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 1. Direkt bean name ile de controller verilebilmektedir, direkt welcome.htm WelcomeController yonlendirdigimiz gibi (Handler Mapping)
 * 2. Bu aslinda bir BeanNameUrlHandlerMapping ornegi
 * 2. Burada return edecegimiz ModelAndView name'ine bakacak sekilde dosya arayacaktir (welcome.jsp gibi)
 * 3. Spring 5 oncesi direkt ControllerClassNameHandlerMapping ile sadece class adi verilerek verilebilmekteydi ancak kaldirildi
 * @author korayk
 *
 */
public class WelcomeController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView model = new ModelAndView("welcome"); // bu isimde jsp arayacaktir
		model.addObject("message", "Welcome Controller!");
		return model;
	}

}
