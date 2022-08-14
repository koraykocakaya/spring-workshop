package com.kk.rest.webservices.springbootworkshop.repository;

import com.kk.rest.webservices.springbootworkshop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
