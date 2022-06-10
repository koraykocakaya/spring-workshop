package com.kk.section7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. Autowire normalde yine XML'de beanler arası injectioni specify etmek icin kullanilmakta
 * 2. Autowiring bircok beani inject edecegimiz durumda bizi o karmasikliktan ve detaydan kurtaracaktir
 * 3. constructor-arg ve property ile verilenler autowire'i ezecektir, ayrica Autowire sadece CustomObject icin kullanilmaktadir
 * 
 * @author korayk
 */
public class AutowiringExample {
	

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beansAutowiring.xml");
		MessageService messagaService = (MessageService)context.getBean("messageService");
		System.out.println(messagaService.getMessage());
		
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
