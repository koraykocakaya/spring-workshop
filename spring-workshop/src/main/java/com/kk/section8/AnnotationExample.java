package com.kk.section8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. Xml uzerinde inject etmek yerine Annotationlar ile de birbirine Inject edebiliriz
 * 2. Bunnu icin oncelikle XML'de <context:annotation-config/> eklememiz gerekmekte
 * 3. @Autowired property, constructor veya setter'a yazilarak bu beanin Inject edilmesini saglar, constructorda kullanirsak tum argumentslar zorunlu olacaktir
 * 4. Default'ta required=true calisir yani bulamazsa hata atacaktir, bulamasa da calismasi icin (required=false) yeterli olacaktir
 * 5. Autowired otomatik olarak type uzerinden ilgili beani bulacaktir, birden fazla varsa isme bakacaktir bulamazsa hata atacaktir
 * 6. Ancak bu tip durumlar icin ilgili beande @Qualifier kullanarak hangi beani burada kullanacagimizi belirtebilmekteyiz
 * 7. Annotation ile @PostConstruct ve @PreDestory da verebilmekteyiz
 * 8. Setter veya property icin @Resource (name = "...") ile de inject edebilmekteyiz
 * @author korayk
 */
public class AnnotationExample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beansAnnotation.xml");
		NotificationService notificationService = (NotificationService)context.getBean("notificationService");
		System.out.println(notificationService.send());
		
		context.close();
	}
}
