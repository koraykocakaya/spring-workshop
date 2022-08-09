package com.kk.spring.data.jpa.workshop.section06;

import com.kk.spring.data.jpa.workshop.entity.Course;
import com.kk.spring.data.jpa.workshop.entity.Teacher;
import com.kk.spring.data.jpa.workshop.repository.CourseRepository;
import com.kk.spring.data.jpa.workshop.repository.TeacherRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 1. OneToMany ve ManyToOne birlikte dusunebiliriz, ancak ManyToOne uzerinden kurgulamak daha saglikli olacaktir.
 * 2. Buradaki ornekte de bir teacherin n tane course'u olabilmektedir, bu acidan Course'ta ManyToOne olarak teacher tanimlanabilmektedir
 *  ManyToOne baglarken JoinColumn ile hangi kolondan referans verecegimizi ve bu kolonun tableda adniin ne olacagi setlenebilmektedir
 *  Bu ornek ozelinde Course table'i icin teacher_id adinda bir kolon yaratildi ve bu Teacher'in teacherId fieldi referans verildi
 * 3. Asagidaki ornekteki gibi once teacher sonra onu kullanan courseleri save almak istiyorsak Cascade Merge yapmamiz gerekli olacaktir
 * @author korayk
 */
@SpringBootTest
public class JPARelationshipOneToManyTest {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	void teacherSaveTest() {
		Teacher teacher = Teacher.builder().firstName("Koray3").lastName("Kocakaya3").build();
		teacherRepository.save(teacher);
		
		Course course2 = Course.builder().credit(124).title("courser12345").teacher(teacher).build();
		Course course1 = Course.builder().credit(123).title("courser123445").teacher(teacher).build();

		courseRepository.save(course1);
		courseRepository.save(course2);
	}
	
}
