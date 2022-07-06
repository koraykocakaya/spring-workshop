package com.kk.spring.data.jpa.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kk.spring.data.jpa.workshop.entity.Student;

@Repository
public interface StudentQueryRepository extends JpaRepository<Student, Long> {

	// JPQL example
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	// Birden fazla kayit donerse hata atacaktir
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailAddress(String emailId);
	
	// JPQL 
	@Query("select s.firstName from Student s where s.lastName = ?1")
	List<String> listStudentFirstNameByLastName(String soyad);
	
	// Native SQL
	@Query (
			value = "Select s.last_name as lastName from student s group by s.last_name",
			nativeQuery = true
	)
	List<String> listStudentLastNameGroupByNative();
	
	// Native SQL-Named param
	@Query (
			value = "Select * from student s where s.last_name = :lastName",
			nativeQuery = true
	)
	List<Student> listStudentbyLastNameNameParam(@Param("lastName") String lName);
	
	
	
	
}