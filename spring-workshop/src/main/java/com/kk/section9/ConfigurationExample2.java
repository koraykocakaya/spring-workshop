package com.kk.section9;

import com.kk.section9.annotatedBean.Vehicle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * 1. Ayni tipte iki farkli bean yarattigimizda default birini donmek istersek @Primary annotationini kullabilmekteyiz.
 * 2. Diger beani yine ismini kullanarak donebilmekteyiz
 * @author korayk
 */
public class ConfigurationExample2 {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Vehicle vehicle = context.getBean(Vehicle.class);
		
		System.out.println(vehicle.getSpeed());
		
		Vehicle bike = (Vehicle)context.getBean("bike");
		System.out.println(bike.getSpeed());
		context.close();
	}
}
