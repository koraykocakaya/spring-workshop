package com.kk.section9;

import com.kk.section9.bean.Person;
import com.kk.section9.bean.ProductService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * 1. Configuration xml kullanmadan direkt Java uzerinden de verilebilmektedir, Bunun icin ilgili classa @Configuration verilmelidir
 * 2. Burada JAva ile conf verdigimiz icin AnnotationConfigApplicationContext ile IOC Containeri initialize etmekteyiz
 * 3. Configuration classi icerisinde @Bean ile metot isminde ilgili beanler yaratimaktadir, bu beanlere class uzerinden de erisilebilmektedir
 * 4. Burada ek olarak @Bean("...") vererek Bean'e ayrica isim verilebilmektedir
 * 5. Birden cok Configuration classi verilebilmektedir, bunlar register ile contexte yuklenebilmektedir
 * 6. Ayrica Configuration classlarinda @Import annotationu ile farklı bir Configuration classi da import edilebilir ve ilgili beanler kullabilecektir
 * 7. Beanleri sadece @Bean ile Config classi uzerinden yaratmak sorun olabilecegi icin @ComponentScan ile belirli bir package taratilabilmektedir
 * 8. Bu package icerisinde @Component veya @Service ile isaretlenen class icin Bean yaratilip contexte yuklenecektir
 * 9. Prototype icin destroy cagrilmamakta, cunku Spring prototype beanlerinin Complete lifecycle'larini yonetmemektedir
 * 10. Beanler otomatik eager yuklenmektedir, yani Spring tamamini initialize esnasinda yukler. 
 * 11. Ancak @Lazy ile istenilen Beanlerin Lazy yani cagrildigi zaman yuklenmesi saglanabilmektedir
 * 12. Component ve Autowired icin kullanilmak isteniyorsa ikisinde de Lazy olarak isaretlenmesi gerekmektedir 
 * @author korayk
 */
public class ConfigurationExample {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Employee emp = (Employee)context.getBean("getEmployee");
		System.out.println(emp);
		
		emp.setAge(100);
		
		Employee empNew = (Employee)context.getBean("getEmployee");
		System.out.println(empNew);
		
		Employee emp2 = (Employee)context.getBean("employeeBean2");
		System.out.println(emp2);
		
		Person p = context.getBean(Person.class);
		System.out.println(p);
		
		ProductService ps = context.getBean(ProductService.class);
		System.out.println(ps.getDescription());
		
		context.close();
		
	}
}
