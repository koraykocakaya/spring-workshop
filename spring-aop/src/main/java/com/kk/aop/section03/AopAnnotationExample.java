package com.kk.aop.section03;

import com.kk.aop.section03.bean.Student;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * 1. Aspect icin kullancagimiz classi @Aspect annotationi ile isaretlemekteyiz, eger Xml kullanmayacaksak bunu Bean haline getirmemiz gerekmekte
 * 2. Bunun haricinde ilgili Configuration classinda da @EnableAspectJAutoProxy eklememiz gerekli olacaktir
 *  Xml ile yapsaydik da <aop:aspectj-autoproxy/> eklememiz gerekecekti
 * 3. Aspect'i kullandigimizda araya bir Proxy objesi girer ve call islemi onun uzerinden yurur, 
 *  İlgili beanden proxy objesi olusturulmasi islemine Weaving adi verilmektedir, Spring sadece runtime weaving yapmaktadir 
 * 4. Aspect sinifi icerisinde herhangi bir islem yapmayan bir metot tanimlayarak 
 * 	bu metoda @PointCut ile istedigimiz metodu veya hangi packagedaki metotlar icin aksiyon almak istiyorsak onlari belirtebiliriz
 * 5. Bu yapi icerisinde metodun donus tipi ve metodun name-patterni zorunludur, bunlari * ile hepsi olarak belirtebiliriz
 * 6. Burada complex yapilar da kullanilabilm ekte, ilk parametresi Long alan get ile baslayan metotlar vs. gibi
 * 7. PointCut tanimi sonrasinda bunu kullanacak Advice'lari tanimlamak gerekecektir
 * 	7.1 Before: Metot cagrilmadan once calisir
 *  7.2 After : Metot cagrildiktan sonra calisir, hata alsa da calisacaktir
 *  7.3 AfterReturning: Metot basariyla sonlandiktan sonra outputu parametre alan bir metot olarak calisacaktir (void metotlarda parametre null olacaktir)
 *  7.4 AfterThrowing: Metot hata aldiginda hatayi parametre alan bir metot olarak calisacaktir
 *  7.5 Around: Metodun hem oncesinde hem sonrasinda calisabilen metodun call edilmesini yoneten Advice'tir. 
 *    Ornegin metot surelerini tutmak gibi islemler icin kullanilmasi gerekebilecektir
 *  8. Birden fazla aspectimiz oldugu durumda calisma siralarini @Order annotationu ile verebilmekteyiz
 * @author korayk
 */
public class AopAnnotationExample {

	public static void main(String[] args) {
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beansForAspect.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student = context.getBean(Student.class);
		System.out.println(student.getClass());
		student.getName();
		student.setName("Ahmet");
		student.getError();
//		System.out.println(student.getName());
		
		context.close();
	}
}
