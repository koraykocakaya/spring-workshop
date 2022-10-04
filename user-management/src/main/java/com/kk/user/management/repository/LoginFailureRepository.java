package com.kk.user.management.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kk.user.management.entity.LoginFailure;
import com.kk.user.management.entity.User;

@Repository
public interface LoginFailureRepository extends JpaRepository<LoginFailure, Integer>{

	public List<LoginFailure> findAllByUserAndCreatedDateIsAfter(User user, Timestamp createdDate);
}
