package com.kk.spring.data.jpa.workshop.section04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kk.spring.data.jpa.workshop.repository.StudentTransactionalRepository;

/**
 * 1. Yapilacak islem Transaction gerektiriyorsa ilgili metodu veya direkt Repository'i @Transactional ile isaretleyebiliriz
 * 2. Burada ornek oldugu icin direkt metodu isaretledik ancak uygulamada 
 *  service layerinda @Transactional kullanip farkli Repository'lerden yapilan islemler sonrasi commitlemek saglikli olacaktir
 * 3. Su anki ornekte metot girisinde Transaction baslayacak metot sonunda da commit edilecektir
 * 4. Bu ornek gibi DB'deki veriyi modify ettigimiz islemlerde @Modifying annotationu ile isaretlememiz gerekmektedir
 *  
 * @author korayk
 *
 */
@SpringBootTest
public class RepositoryTransactionalTest {

	@Autowired
	StudentTransactionalRepository studentTransactionalRepository;
	
	@Test
	public void updateStudentNameByEmailTest(){
		int returnVal = studentTransactionalRepository.updateStudentNameByEmail("Koray-updated", "koraykocakaya@testmail41");
		System.out.println(returnVal);
	}
	
	
}
