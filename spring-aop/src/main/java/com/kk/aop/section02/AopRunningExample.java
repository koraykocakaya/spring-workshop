package com.kk.aop.section02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. Oncelikle bir Aspect (buradaki LogAspect gibi) tanimlayip bu aspect icerisinde hangi noktalara islem yapacagimizi belirtmek icin JoinPoint(veya Pointcut tanimlamaktayiz)
 * 2. JoinPoint belli bir classa ait belli bir metot vs. olarak verilebilmektedir
 * 3. Ancak genelde bir package icindeki metotlar vs. verilmek istendiginde PointCut kullanilmaktadir, burada expression ile detayli verilebilmektedir
 * 4. Buradaki ornekte (beans.xml) "execution(* com.kk.aop.section02.*.*(..))" verdigimizde section02 altindaki Beanlerin tum metotlari icin aksiyon alinacak sekilde isaretlemis olduk
 * 5. Burada ayni zamanda tek bir classin tek bir metodu da isaretlenebilmektedir.
 * 6. Aspect icerisinde PointCut tanimindan sonra Advice typelari ile oncesi, sonrasi vs. islemlerini bu PointCutlarda uygulayabilmekteyiz
 * @author korayk
 */
public class AopRunningExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Person p = context.getBean(Person.class);
		p.getAge();
		p.getName();
		
		Company c = context.getBean(Company.class);
		c.getName();
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
