package com.kk.spring.data.jpa.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kk.spring.data.jpa.workshop.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Override
	default void deleteAll() {
		
	}
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String namee);
	
	public List<Student> findByGuardianName(String name);
}
