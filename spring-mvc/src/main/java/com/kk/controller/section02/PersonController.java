package com.kk.controller.section02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kk.model.Person;

/**
 * 1. Form handling icin kullanildi, person2.jsp'den de gorulecegi uzere butona tiklandiginda ilgili bilgilerle addPerson cagrildi <br> 
 * 2. Burada ilk metotta command ile bos Person gonderdik, Spring sonrasinda addPerson metodunda ilgili bu objeyi dolduraracak sekilde gonderdi <br>
 * 3. Direkt olarak static sayfalara da yonlendirme yapilabilmektedir <br>
 * 4. Jsp'de kullanmak istedigimiz combo gibi yapilari countryList ornegindeki gibi @ModelAttribute vererek doldurabilmekteyiz
 * @author korayk
 *
 */
@Controller
public class PersonController {

	@RequestMapping (path = "/person", method = RequestMethod.GET)
	public ModelAndView getPerson() {
		return new ModelAndView("person", "command", new Person());
	}
	
	@RequestMapping (path = "/addPerson", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute Person person, ModelMap model) {
		model.addAttribute("name", person.getName());
		model.addAttribute("surname", person.getSurname());
		model.addAttribute("age", person.getAge());
		return "result";
	}
	
    @ModelAttribute("countryList")
    public Map<String, String> getCountryList() {
       Map<String, String> countryList = new HashMap<String, String>();
       countryList.put("US", "United States");
       countryList.put("CH", "China");
       countryList.put("SG", "Singapore");
       countryList.put("MY", "Malaysia");
       return countryList;
    }
}
