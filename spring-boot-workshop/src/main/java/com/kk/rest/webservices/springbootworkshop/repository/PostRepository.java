package com.kk.rest.webservices.springbootworkshop.repository;

import java.util.List;

import com.kk.rest.webservices.springbootworkshop.model.Post;
import com.kk.rest.webservices.springbootworkshop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
}
