package com.kk.spring.data.jpa.workshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kk.spring.data.jpa.workshop.entity.Student;

@Repository
public interface StudentTransactionalRepository extends JpaRepository<Student, Long> {

	@Modifying
	@Transactional
	@Query(
			value =  "update student set first_name = ?1 where email_address = ?2 ",
			nativeQuery = true
	)
	int updateStudentNameByEmail(
			String firstName, 
			String email
	);
	
}
