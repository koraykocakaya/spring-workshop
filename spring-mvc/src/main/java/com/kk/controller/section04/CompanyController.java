package com.kk.controller.section04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1. Burada InternalResourceViewResolver kullandik, bu ilgili URI mapini yapmamizi sagladi
 * 2. Bu ornekte /company cagrildiginda  /WEB-INF/jsp/hello2.jsp cagrilacak, cunku prefix:/WEB-INF/jsp/ viewName: hello, suffix:2.jsp 
 * @author korayk
 *
 */

@Controller
@RequestMapping ("/company")
public class CompanyController {

	@RequestMapping (method = RequestMethod.GET)
	public String asd(ModelMap modelMap) {
		modelMap.addAttribute("message", "Company Example");
		return "hello";
	}
	
}
