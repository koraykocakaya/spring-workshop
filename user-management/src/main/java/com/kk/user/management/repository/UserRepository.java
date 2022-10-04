package com.kk.user.management.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kk.user.management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public Optional<User> findByUsername(String username);

	public List<User> findAllByAccountNonLockedAndLastModifiedDateIsBefore(boolean accountNonLocked, Timestamp lastModifiedDate);
}
