package com.kk.spring.data.jpa.workshop.section05;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kk.spring.data.jpa.workshop.entity.Course;
import com.kk.spring.data.jpa.workshop.entity.CourseMaterial;
import com.kk.spring.data.jpa.workshop.repository.CourseMaterialRepository;
import com.kk.spring.data.jpa.workshop.repository.CourseRepository;

/**
 * 1. Entityleri tanimlarken aralarindaki iliskileri de tanimlayabilmekteyiz
 * 2. Ornegin CourseMaterial Course icermekte ve aralarinda @OneToOne relationship bulunmakta.
 * 3. Burada bunu @JoinColumn annotationi ile hangi column ile baglayacagimizi ve referans column tanimlanabilmekte
 * 4. Course olmadan CourseMaterial save almak istendiginde Course olmadigi icin unsaved transient instance hatasi alacaktir
 * 5. Bu sorunun cozumu icin bu relationshipte Cascade verebiliriz, bu nasıl davranacagini belirtmek icin kullanilmaktadir, 
 *  bu ornekte once Course yaratip, sonra CourseMaterial yaratip ona baglayacaktir (CascadeType.ALL veya CascadeType.PERSIST ile)
 * 6. Entity'i get ederken bagli oldugu Entity Fetch Type'i Eager veya Lazy olarak ayarlanabilmektedir, 
 *  Eager oldugunda ana entity yuklenirken anlik yuklenir, Lazy oldugunda ise yuklenmez
 * 7. Ilgili iliskileri bidirectiobal olarak da kullanabilmekteyiz, bunun icin ornekteki gibi 
 *  Course sinifina CourseMaterial ekleyip bunu mappedBy ile isaretlememiz yeterli olacaktir
 *  Digerindeki gibi burada da FetchType ayrica belirtilebilmektedir 
 * @author korayk
 *
 */
@SpringBootTest
public class JPARelationshipTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void saveCourseMaterialTest() {
		Course course = Course.builder()
							  .credit(100)
							  .title("Course 2")
							  .build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
													  .url("www.asd.com")
													  .course(course)
													  .build();
		
		courseMaterialRepository.save(courseMaterial);
	}
	
	@Test
	public void listCourseMaterialTest() {
		List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
		System.out.println(courseMaterialList);
		
	}
	
	@Test
	public void listCourseTest() {
		List<Course> courseList = courseRepository.findAll();
		System.out.println(courseList);
	}
}
