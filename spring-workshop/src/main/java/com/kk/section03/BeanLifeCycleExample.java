package com.kk.section03;

import com.kk.section01.ExampleBean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. Bean yaratildiktan sonra init-method ile verdigimiz method cagrilacaktir
 * 2. Bean destroy edilmeden hemen once de destroy-method ile verdigimiz method cagrilacaktir
 * 3. Bunlari DisposableBean ve InitializingBean'i implement ederek otomatik de yapabiliriz, ancak bu sekilde method isimleri manuel verilebilmekte
 * 4. Bu metotlar void ve parametre almayan olmali
 * 5. Burada context icin close veya registerShutdownHook cagirmak onemli yoksa destruction metotlari calismayacaktir 
 * 6. Eger cok fazla bean icin init ve destroy metodu varsa xml'de direkt beans icinde default-init-method verebiliriz
 * @author korayk
 */
public class BeanLifeCycleExample {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beansLifeCycle.xml");
		ExampleBean exampleBean = (ExampleBean)context.getBean("exampleBeanSection3");
		
		System.out.println(exampleBean.getName());
		
		LifeCycleBean lifeCycleBean = (LifeCycleBean)context.getBean("lifeCycleBean");
		System.out.println(lifeCycleBean);
		context.registerShutdownHook();
	}
}
