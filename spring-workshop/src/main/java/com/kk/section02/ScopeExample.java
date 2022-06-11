package com.kk.section02;

import com.kk.section01.ExampleBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. beanlere scope verebilmekteyiz, default scope singleton yani bir bean yaratildiginda destruct olana kadar ayni bean devam etmekte
 * 2. Bu yuzden bir onceki ornekte setName cagirip tekrar contextten cektigimizde ayni kayit gelmisti
 * 3. Burada ise scope'u prototype olarak ayarladik yani her istekte yeni bir obje donecek sekilde ayarlamis olduk (Prototype Design Pattern)
 * 4. Stateful icin Prototype, stateless (sadece bir defa initialize edilir) icin Singleton kullanilmaktadir
 * @author korayk
 */
public class ScopeExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beansScope.xml");

		ExampleBean bean = (ExampleBean) context.getBean("exampleBeanSection1");
		bean.setName("Ahmet");
		System.out.println(bean.getName());

		// Bu kez prototype oldugu icin her istek geldiginde yeni bir obje return edecektir
		ExampleBean bean2 = (ExampleBean) context.getBean("exampleBeanSection1");
		System.out.println(bean2.getName());

		((ClassPathXmlApplicationContext) context).close();
	}
}
