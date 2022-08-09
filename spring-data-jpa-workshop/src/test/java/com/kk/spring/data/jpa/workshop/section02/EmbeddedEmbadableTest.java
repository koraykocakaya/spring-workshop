package com.kk.spring.data.jpa.workshop.section02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kk.spring.data.jpa.workshop.entity.Guardian;
import com.kk.spring.data.jpa.workshop.entity.Student;
import com.kk.spring.data.jpa.workshop.repository.StudentRepository;

/**
 * 1. Table'da bazi kolonlar icin ayri bir class uzerindne yaratip onu direkt class icinde bir variable gidi tanimlayabilmekteyiz
 * 2. Burada da Guardian ayri bir class yapip @Embeddable ile isaretleyip, 
 * 	Student classinda da @Embedded ile Guardian'i variable gecerek; Guardiandaki parametrelerin de Student parametreleri gibi kullanmamız sağlandı.
 * 3. Aslinda Guardian hic yaratmayip icindeki  fieldlari direkt Student'a ekleyebilirdik ancak kullanim kolayligi acisindan bu daha saglikli olmakta
 * 4. Guardian'da @AttributeOverride ile kolon adini setleyebildik, boylece attribute isimlerini istenilen sekilde verip kolon adini degistirebildik
 * @author korayk
 *
 */
@SpringBootTest
class EmbeddedEmbadableTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Guardian guardian = Guardian.builder()
									.gEmail("gemail1")
									.name("Guardian name")
									.gMobile("g123456")
									.build();
		
		Student student = Student.builder()
								 .emailId("email123@" + Math.random())
								 .firstName("Koray99")
								 .lastName("Kocakaya3")
								 .guardian(guardian)
								 .build();
				
		studentRepository.save(student);
		 
	}
	
}
