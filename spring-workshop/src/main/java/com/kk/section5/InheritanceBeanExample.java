package com.kk.section5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. Beanlerde de Java gibi inheritance bulunmaktadir, Child Parentin ozelliklerini inherit etmektedir
 * 2. Bu islemi xml'de parenti belirterek verilebilmektedir
 * 3. Child ilgili kayit icin parentin fieldini ezebilmektedir
 * @author korayk
 */
public class InheritanceBeanExample {
	
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beansInheritance.xml");
		ParentBean parent = context.getBean("parentBean", ParentBean.class);
		System.out.println(parent.getName2());
		System.out.println(parent.getName3());
		
		ChildBean child = context.getBean("childBean", ChildBean.class);
		System.out.println(child.getName1());
		System.out.println(child.getName2());
		// name3 setlenmedi ancak parenttan alindi
		System.out.println(child.getName3());
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
