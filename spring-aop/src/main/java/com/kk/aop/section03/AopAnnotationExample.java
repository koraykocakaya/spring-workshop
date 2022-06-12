package com.kk.aop.section03;

import com.kk.aop.section03.Bean.Student;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * 1. Aspect icin kullancagimiz classi @Aspect annotationi ile isaretlemekteyiz, eger Xml kullanmayacaksak bunu Bean haline getirmemiz gerekmekte
 * 2. Bunun haricinde ilgili Configuration classinda da @EnableAspectJAutoProxy eklememiz gerekli olacaktir
 * 3. Aspect sinifi icerisinde herhangi bir islem yapmayan bir metot tanimlayarak 
 * 	bu metoda @PointCut ile istedigimiz metodu veya hangi packagedaki metotlar icin aksiyon almak istiyorsak onlari belirtebiliriz
 * 4. Burada complex yapilar da kullanilabilm ekte, ilk parametresi Long alan get ile baslayan metotlar vs. gibi
 * 5. PointCut tanimi sonrasinda bunu kullanacak Advice'lari tanimlamak gerekecektir
 * 	5.1 Before: Metot cagrilmadan once calisir
 *  5.2 After : Metot cagrildiktan sonra calisir, hata alsa da calisacaktir
 *  5.3 AfterReturning: Metot basariyla sonlandiktan sonra outputu parametre alan bir metot olarak calisacaktir
 *  5.4 AfterThrowing: Metot hata aldiginda hatayi parametre alan bir metot olarak calisacaktir
 *  5.5 Around: Metodun hem oncesinde hem sonrasinda calisabilen metodun call edilmesini yoneten Advice'tir. 
 *    Ornegin metot surelerini tutmak gibi islemler icin kullanilmasi gerekebilecektir
 * @author korayk
 */
public class AopAnnotationExample {

	public static void main(String[] args) {
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beansForAspect.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student = context.getBean(Student.class);
		student.getName();
		student.setName("Ahmet");
		student.getError();
//		System.out.println(student.getName());
		
		context.close();
	}
}
