package com.kk.spring.data.jpa.workshop.section01;

import com.kk.spring.data.jpa.workshop.entity.Student;
import com.kk.spring.data.jpa.workshop.repository.StudentRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 1. Spring datada oncelikle tablolari map edecek classlari yaratmamiz gerekmektedir (ORM)
 * 2. Burada Student classinda gorecegimiz gibi classi @Entity annotationi ile isaretlemekteyiz, 
 *  eger @Table ile name vermezsek direkt olarak ayni isimdeki tablo ile eslesecektir
 * 3. JPA islemleri JPARepository interface'ini extend eden bir interface uzerinden yurutebilmektedir
 * 4. Burada ilgili classi ve onun id tipini JPARepository'e parametre gecerek kullanilabilmektedir (StudentRepository icin Student ve Long)
 * 5. Repository save, delete, findById gibi bircok default metot sunmaktadir, bu aksiyonlari gerceklestirmek icin bunlari cagirmak yeterli olacaktir
 * 6. Bu esnekligin riskli olmamasi adina ilgili repository'lerde bazı metotlari Override edip default behavior degistirilebilmektedir
 *  Ornegin StudentRepository icin deleteAll metodunda bu uygulanmis oldu
 * 7. Bununla birlikte JPA direkt metot isimleriyle sorgu yapabilmemizi de saglamaktadir, 
 *  ornegin findByFirstName metodu firstName uzerinden = ile kontrol edecek sekilde calismaktadir 
 * 8. Benzer sekilde findByFirstNameContaining gibi metotlari da otomatik LIKE olacak sekilde cevirebilmektedir
 * @author korayk
 *
 */
@SpringBootTest
class EntityRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		
		Student student = Student.builder()
									.emailId("email12345@" + Math.random())
									.firstName("Koray99")
									.lastName("Kocakaya3")
									.build();
//		studentRepository.save(student);
//		studentRepository.deleteAll();
		 
	}
	
	@Test
	public void listStudentByName() {
		System.out.println("---------------------------");
		System.out.println("Name Koray List: " + studentRepository.findByFirstName("Koraaaay").size());
		System.out.println("---------------------------");
	}
	
	@Test
	public void listStudentByNameContaining() {
		System.out.println("---------------------------");
		System.out.println("Name Koray Contanining List: " + studentRepository.findByFirstNameContaining("Koray").size());
		System.out.println("---------------------------");
	}
	
	@Test
	public void listStudentByGuardianName() {
		System.out.println("---------------------------");
		System.out.println("Guardian Name Ahmet: " + studentRepository.findByGuardianName("Ahmet"));
		System.out.println("---------------------------");
	}
	
}
