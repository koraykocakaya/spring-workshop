package com.kk.section06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. Javada tum classlar mumkun oldugunca birbirinden bagimsiz olmalidir
 * 2. Asagidaki CustomSet ornegindeyse direkt customMap objesi constructorda yaratilmaktadir ve bu bagimliligi artirmaktadir
 * 3. Bunun icin kullanilacak cozum DI, bu sayede bagimlilik azaltilir ve ayni objeyi farkli yerlerde kullanabiliriz ve unit test yazmak kolaylasir
 * 4. DI'i setter veya constructor injection ile saglayabiliriz 
 * 5. name, type, index vs. uzerinden constructor injection verilebilmektedir
 * 6. Setterda ise property gibi yapilmakta sadece value yerine ref vermekteyiz
 * 7. Beanleri de classlar gibi, property veya constructor-arg icinde direkt inner bean olarak tanimlayabiliriz, ayrica tanimlamak zorunda degiliz
 * 8. String, int ve Custom Object typelari haricinde list, map gibi coklu veri tutan yapilari da inject edebiliriz
 * @author korayk
 */
public class DependencyInjectionExample {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beansDI.xml");
		Car carBean =  context.getBean("carBean", Car.class);
		System.out.println(carBean.getEngine().getName());
		System.out.println(carBean.getEngine2().getName());
		System.out.println(carBean.getManualList());
		
		((ClassPathXmlApplicationContext)context).close();
	}
}

class CustomSet{
	
	private CustomMap customMap;
	
	public CustomSet() {
		customMap = new CustomMap();
	}
	
	public CustomMap getCustomMap() {
		return customMap;
	}
}


class CustomMap{
	
}
