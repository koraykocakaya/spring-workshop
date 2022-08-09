package com.kk.spring.data.jpa.workshop.section08;

import java.util.Arrays;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import com.kk.spring.data.jpa.workshop.entity.Course;
import com.kk.spring.data.jpa.workshop.entity.Student;
import com.kk.spring.data.jpa.workshop.repository.CourseRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 1. Many to many icin iki tablonun birbirine referasni yetersiz olacaktir, bu yuzden 3. tablo zorunlu hale gelecektir
 * 2. Bunun icin @ManyToMany tanimladgimiz yerde @JoinColumn yerine @JoinTable tanimi yapilmasi gerekmektedir
 *  Bu tanim icerisinde joinColumns ile bu ortak tabloya (student_course_map) icinde bulundugumuz tabledan (course) hangi kolon (courseId) ile baglayacagimiz belirtebiliriz
 *  Burada ek olarak diger tabledan (student) da verecegimiz kolonu inverseJoinColumns ile verebilmekteyiz  
 * @author korayk
 */
@SpringBootTest
public class JPARelationshipManyToOneManyTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	void saveCourseWithStudents() {
		Student s1 = Student.builder().emailId("email1_**").firstName("Student1").build();
		Student s2 = Student.builder().emailId("email2_**").firstName("Student2").build();
		
		
		Course c1 = Course.builder().credit(99).title("Course Manytomany1").students(Arrays.asList(s1, s2)).build();
		
		courseRepository.save(c1);
	}
	
}
