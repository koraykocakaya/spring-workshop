package com.kk.controller.section01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1. @Controller ile bu sinifin Controller oldugunu belirtmis olmaktayiz
 * 2. @RequestMapping ile hangi isteklerin bu Controllera gelecegi belirtilmis oldu, direkt metotlarda veya direkt tum sinif icin kullanabiliriz 
 * 3. Buradaki gibi ModelMap'e koydugumuz featurelar goruntuleyecegimiz jsp'de kullabilabilmektedir
 * 4. Burada response'u jsp ile dondurduk, ancak Spring MVC xml, json, html gibi farkli teknolojileri de desteklemektedir.
 * 5. Metotlarda dondugumuz Stringe gore ilgili jsp'i arayacaktir (helloCustom.jsp gibi), prefix ve suffixi Helloweb-servlet.xml'de belirtilmisti
 * @author korayk
 *
 */
@Controller
public class HelloController{
 
   @RequestMapping(path = {"/hello", "/helloDiger"}, method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");

      return "hello";
   }
   
   @RequestMapping(path = {"/helloCustom"}, method = RequestMethod.GET)
   public String printHelloPath(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework2!");
      model.addAttribute("customMessage", "Custom Message");

      return "helloCustom";
   }

}