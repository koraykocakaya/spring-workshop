package com.kk.section10;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. ApplicationContext icin de baslatildiginda,refresh edildiginde vs. kullanabilecegimiz eventler bulunmaktadir
 * 2. ApplicationListener interface'ini implement eden Beanler yardimiyla bu aksiyonlar durumunda ilgili metotlar cagirilabilmektedir
 * 3. Burada ApplicationListener'a ContextStartedEvent, ContextClosedEvent gibi eventleri parametre gecerek ilgili event durumu handle edilebilmektedir
 * 4. Ayrica direkt @EventListener kullanilarak da eventListener tanimlanabilmektedir
 * 5. Ek olarak kendi eventimizi de tanimlayabilmekteyiz, bu tanimi yaptiktan sonra ApplicationEventPublisherAware implement eden bir class yardimiyla bunu publish edebiliriz
 * 6. Ayrica direkt bir classi icinde ApplicationEventPublisher'i Autowired ederek de Bean olarak yaratarak CustomEventi publish etmek icin kullanabiliriz 
 * 7. Bu class icerisinde ApplicationEventPublisher setleyip beanden cagiracagimiz metotta da bu publisher ile publishEvent metodunu CustomEvent parametresi ile cagirabiliriz 
 * @author korayk
 */
public class ContextHandlerExample {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(HandlerConfig.class);
		
		context.start();
		HandlerExampleBean bean = (HandlerExampleBean)context.getBean("beanEx");
		System.out.println(bean.getName());
		
		CustomEventPublisher publisher = context.getBean(CustomEventPublisher.class);
		CustomEventPublisherAware publisherAware = context.getBean(CustomEventPublisherAware.class);
		publisher.publish();
		publisherAware.publish();
		
		context.stop();
		context.close();
	}
}
