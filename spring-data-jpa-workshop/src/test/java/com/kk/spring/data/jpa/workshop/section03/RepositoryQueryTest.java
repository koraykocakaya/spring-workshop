package com.kk.spring.data.jpa.workshop.section03;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kk.spring.data.jpa.workshop.entity.Student;
import com.kk.spring.data.jpa.workshop.repository.StudentQueryRepository;

/**
 * 1. Bazen istedigimiz querye direkt metot isimleri ile ulasamayabiliriz
 * 2. Bu tarz durumlar icin JPQL kullanarak kendi sorgumuzu yazip onu kullanabiliriz
 * 3. Burada onemli olan metoda @Query annotationu ile calistirmasini istedigimiz querynin verilmesi
 * 4. Buradaki query native olmadigi icin direkt class ve fieldi uzerinden sorgunun yazilmasi gerekmekte
 * 5. Match eden birden fazla kayit olabilecekse onu List donecek sekilde handle etmemiz gerekecektir
 * 6. JPQL yeterli olmadigi noktalarda NativeQuery de yazmamiz gerekebilecektir, 
 *  bunun icin @Query ile annotationi icinde nativeQuery=true vermemiz yeterli olacaktir 
 * 7. Query icin ? ile veri girmek yerine @Param annotationi ile belirtip onu kullanabiliriz, belirttigimiz ismi sorguda ayni isimle kullanabiliriz
 * @author korayk
 *
 */
@SpringBootTest
class RepositoryQueryTest {

	@Autowired
	private StudentQueryRepository studentQueryRepository;
	
	@Test
	public void getStudentByEmailAddressTest() {
		Student student = studentQueryRepository.getStudentByEmailAddress("koraykocakaya@testmail3");
		System.out.println("Student is: " + student);
	}
	
	@Test
	public void getStudentFirstNameByEmailAddressTest() {
		String studentFirstName = studentQueryRepository.getStudentFirstNameByEmailAddress("koraykocakaya@testmail4");
		
		System.out.println("Student first name: " + studentFirstName);
	}
	
	@Test
	public void listStudentFirstNameByLastNameTest() {
		List<String> firstNameList = studentQueryRepository.listStudentFirstNameByLastName("Kocakaya3"); 
		System.out.println("First Name List: " + firstNameList);
	}
	
	@Test
	public void listStudentLastNameGroupByNativeTest() {
		List<String> lastNameList = studentQueryRepository.listStudentLastNameGroupByNative(); 
		System.out.println("Last Name List: " + lastNameList);
	}
	
	@Test
	public void listStudentbyLastNameNameParamTest() {
		List<Student> studentList = studentQueryRepository.listStudentbyLastNameNameParam("Kocakaya3"); 
		System.out.println("Student List: " + studentList);
	}
	
}
