package com.kk.spring.data.jpa.workshop.section07;

import static org.mockito.ArgumentMatchers.contains;

import java.util.List;

import com.kk.spring.data.jpa.workshop.entity.Course;
import com.kk.spring.data.jpa.workshop.repository.CoursePaginationRepository;
import com.kk.spring.data.jpa.workshop.repository.CourseRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * 1. JPARepository PagingAndSortingRepository'i extend etmektedir, bu classta pageable ve sort parametresi alan metotlar bulunmaktadir
 * 2. Pagingi ozellikle cok fazla verisi olan tablolarda belli bir ordera gore bir parcayi cekip gostermek adina kullanilmaktadir
 * 	Asagidaki ornekte de goruldugu gibi PageRequest ile Pageable yaratip bunu findAll'a parametre geceerek kullanabiliriz
 * 	Burada ilk sayfadaki (0 ilk) 3 kaydi getir veya 10.sayfadaki 3 kaydi getir demis olduk (yani ilk 30 kaydi atla sonraki 3 getir)
 * 3. findAll metodu PAge<T> donmektedir, bunun icerisinde toplam kac kayit oldugu, kac sayfa oldugu, istenilen sayfada kac kayit oldugu gibi bilgilere erisilebilmektedir
 * 4. Paginationda ayrica sort parametresi de gecilebilmektedir, burada hangi fielda gore hangi sekilde (ASC,DESC) sort yapabilecegimiz belirtilebilmektedir
 * 5. Ornekte de oldugu gibi birden cok field uzerinden and ile sortlari baglayabilmekteyiz
 * 6. Custom querylerde Paging kullanmak icin metodu Pageable parametresi alacak sekilde yazmak yeterli olacaktir
 * 7. Custom query'i direkt Page donecek sekilde de yapip ilgili verilerin toplam element vs. gibi gonderilmesi saglanabilmektedir
 * @author korayk
 */
@SpringBootTest
public class PaginationSortingTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CoursePaginationRepository coursePaginationRepository;
	
	@Test
	void findAllPagination() {
		Pageable pageableFirstPage = PageRequest.of(0, 3);
		
		Pageable pageableSecondPage = PageRequest.of(10, 2);
		
		List<Course> courseFirstPageList = courseRepository.findAll(pageableFirstPage).getContent();
		
		Page<Course> coursePage = courseRepository.findAll(pageableSecondPage);
		List<Course> courseSecondPageList = coursePage.getContent();

		System.out.println(courseFirstPageList);
		
		System.out.println(courseSecondPageList);
		System.out.println(coursePage.getNumber());
		System.out.println(coursePage.getNumberOfElements());
		System.out.println(coursePage.getTotalElements());
		System.out.println(coursePage.getTotalPages());
	}
	
	@Test
	void findAllPaginationAndSort() {
		Pageable pageableAscPage = PageRequest.of(0, 3, Sort.by(Direction.ASC, "title"));
		
		Pageable pageableDescPage = PageRequest.of(0, 3, Sort.by("title").descending().and(Sort.by("credit")));
		
		List<Course> courseListTitleAsc = courseRepository.findAll(pageableAscPage).getContent();
		List<Course> courseListTitleDesc = courseRepository.findAll(pageableDescPage).getContent();
		
		System.out.println(courseListTitleAsc);
		System.out.println(courseListTitleDesc);
		
	}
	
	@Test
	void findFromCustomQueryWithPagination() {
		Pageable pageable = PageRequest.of(1, 4, Sort.by("courseId"));
		List<Course> courseList = coursePaginationRepository.findCoursesByTitle("titl12311", pageable);
		
		Page<Course> coursePage = coursePaginationRepository.findCoursesByTitleWithPage("titl12311", pageable);
		
		System.out.println(courseList);
		System.out.println(coursePage.getNumber());
		System.out.println(coursePage.getTotalPages());
		System.out.println(coursePage.getTotalElements());
	}
}
