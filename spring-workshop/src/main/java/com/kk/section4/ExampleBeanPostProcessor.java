package com.kk.section4;

import com.kk.section1.ExampleBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ExampleBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Name: " + beanName + " before init called, for bean: " + bean); 
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Name: " + beanName + " after init called, for bean: " + bean);
		if(bean instanceof ExampleBean) {
			((ExampleBean)bean).setName("Ahmet");
		}
		return bean;
	}
}
