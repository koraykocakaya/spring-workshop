package com.kk.spring.data.jpa.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kk.spring.data.jpa.workshop.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	
}
