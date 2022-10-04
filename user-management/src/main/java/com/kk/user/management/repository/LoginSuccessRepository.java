package com.kk.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kk.user.management.entity.LoginSuccess;

@Repository
public interface LoginSuccessRepository extends JpaRepository<LoginSuccess, Integer>{

}
