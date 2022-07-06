package com.kk.controller.section04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1. ViewResolver olarak XmlViewResolver da kullanilabilmekte, bu durumda belirli bir xml dosyasi uzerinden (views.xml burada), 
 *  ilgili yonlendirme yapilmakta
 * 2. Bu ornekte helloBean adinda bean donmekte, views.xml icinde bu bean icin yonlendirmenin nasil yapilacagi belirtildi, direkt hello2.jsp cagrildi gibi 
 * 3. Burada farklı ViewResolver kullanildiginda birbirini ezebilmekte, InternalResourceViewResolver XmlViewResolver ezdigi gibi, bunu order ile cozebilmekteyiz
 * 4. Benzer sekilde ResourceBundleViewResolver kullanarak da properties dosyasi yardimiyla da ViewResolver tanimlanabilmektedir
 * @author korayk
 *
 */
@Controller
@RequestMapping("/school")
public class SchoolController {

	@RequestMapping (method = RequestMethod.GET)
	public String printSchool(ModelMap mp) {
		mp.addAttribute("message", "School Controller example");
		return "helloBean";
	}
}
