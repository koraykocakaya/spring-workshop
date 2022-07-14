package com.kk.controller.section01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author korayk
 *
 */
@Controller
@RequestMapping("/example")
public class ExampleController {

	@RequestMapping (method = RequestMethod.GET)
	public String printExample(ModelMap mp) {
		mp.put("message", "Test");
		return "example";
	}
}
