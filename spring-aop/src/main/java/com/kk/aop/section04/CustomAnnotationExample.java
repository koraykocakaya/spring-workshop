package com.kk.aop.section04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.kk.aop.section04.bean.CartService;
import com.kk.aop.section04.bean.ProductService;

/**
 * 1. Bazi metotlarda ilgili packagedaki sadece belli metotlar icin aspect claistirilmak istenilebilmektedir
 * 2. Bunun icin custom annotation tanimlayarak sadece bu annotation ile isaretlenenler calistirilsin denilebilmektedir
 * 3. Custom annotation standart yolla tanimlamaktayiz, sonrasinda expression olarak annotationi vermek yeterli olacaktir
 * 4. Bu ornekteki gibi ProductService'teki getPrice metodunu @Loggable ile isaretledigimiz icin metot cagrilmadan once aspect calisti
 * @author korayk
 *
 */
public class CustomAnnotationExample {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

		CartService cs = context.getBean(CartService.class);
		ProductService ps = context.getBean(ProductService.class);
		
		System.out.println(cs.getPrice());
		System.out.println(ps.getPrice());
		
		System.out.println(cs.getClass());
		// Aspect oldugu icin ps proxy donecektir
		System.out.println(ps.getClass());
		context.close();
	}
}
