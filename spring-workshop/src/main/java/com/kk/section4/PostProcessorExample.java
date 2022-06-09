package com.kk.section4;

import com.kk.section1.ExampleBean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. BeanPostProcessor init metodundan once ve sonra Bean'de islem yapmak icin kullanilmaktadir
 * 2. Bu noktada Beani guncelleme, loglama vs. islemleri yapilabilmektedir
 * 3. Birden cok BeanPostProcessor olmasi durumunda bunlari Order vererek belirli bir sira ile calismasi saglanmaktadir 
 * @author korayk
 */
public class PostProcessorExample {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beansPostProcessor.xml");
		ExampleBean bean = (ExampleBean)context.getBean("exampleBeanSection3");
		System.out.println(bean.getName());
		
		context.registerShutdownHook();
	}
}
