package com.kk.section09;

import com.kk.section09.annotatedBean.Vehicle;
import com.kk.section09.bean.ProductService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. Ayni tipte iki farkli bean yarattigimizda default birini donmek istersek @Primary annotationini kullabilmekteyiz.
 * 2. Diger beani yine ismini kullanarak donebilmekteyiz
 * 3. @PropertySource("app.properties") ile bir properties dosyasi yuklenebilmektedir.
 * 4. Sonrasinda @Value("${productNo}") ile ilgili property degeri fielda setlenebilmektedir
 * 5. @ImportResource annotationu ile Importtakine benzer bu kez xml alacak sekilde islem yapilabilmektedir 
 * 6. Bir beane profile vererek sadece o profilde o ozelliklerle ayaga kalmasi sagalanabilmektedir, ozellikle dev,test,prod gibi profiller kullabilabilmektedir
 * 7. @Component ile verilen scan'de bulunur ve ilk harfi kucuk olacak sekilde adi verilip contexte yuklenecektir
 * 8. @Service Component ile ayni isi yapar sadece Service layer oldugunu belirtmektedir
 * 9. @Controller Spring MVC'de controller oldugunu belirtmektedir
 * @author korayk
 */
public class ConfigurationExample2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(PropertyConfig.class, ApplicationConfig.class);
		context.refresh();
		
		Vehicle vehicle = context.getBean(Vehicle.class);
		
		System.out.println(vehicle.getSpeed());
		
		Vehicle bike = (Vehicle)context.getBean("bike");
		System.out.println(bike.getSpeed());
		
		ProductService ps = context.getBean(ProductService.class);
		System.out.println(ps.getDescription());
		context.close();
	}
}
