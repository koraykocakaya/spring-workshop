package com.kk.spring.data.jpa.workshop.section01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kk.spring.data.jpa.workshop.entity.Student;
import com.kk.spring.data.jpa.workshop.repository.StudentRepository;

/**
 * 1. Spring datada oncelikle tablolari map edecek classlari yaratmamiz gerekmektedir (ORM)
 * 2. Burada Student classinda gorecegimiz gibi classi @Entity annotationi ile isaretlemekteyiz, 
 *  eger @Table ile name vermezsek direkt olarak ayni isimdeki tablo ile eslesecektir
 * 3. 
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
									.emailId("koraykocakaya@testmail4")
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
