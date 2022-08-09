package com.kk.spring.data.jpa.workshop.repository;

import java.util.List;

import com.kk.spring.data.jpa.workshop.entity.Course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePaginationRepository extends JpaRepository<Course, Long>{

	@Query("select c from Course c where c.title = ?1")
	public List<Course> findCoursesByTitle(String title, Pageable pageable);
	
	@Query("select c from Course c where c.title = ?1")
	public Page<Course> findCoursesByTitleWithPage(String title, Pageable pageable);
}
