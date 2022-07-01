package com.kk.section01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. Springin 2 IOC Containeri ApplicationContext ve BeanFactory, container componentlari (bean) yonetmek icin DI kullanir
 * 2. BeanFactory yerine ApplicationContext kullanmaktayiz (Context Factory'i kapsar)
 * @author korayk
 */
public class HelloWorld {
	
	public static void main(String[] args) {
		
		// classpathteki beans.xml dosyasini contexte yukledik
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		// hangi id verdiysek ona gore cekmeliyiz, factory design pattern
		ExampleBean bean = (ExampleBean)context.getBean("exampleBeanSection1");
		bean.setName("Ahmet");
		System.out.println(bean.getName());
		
		// Elimizdeki bean tek oldugu icin ayni name print edilecektir, default scope singleton
		ExampleBean bean2 = (ExampleBean)context.getBean("exampleBeanSection1");
		System.out.println(bean2.getName());
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
