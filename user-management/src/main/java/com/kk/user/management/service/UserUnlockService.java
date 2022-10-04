package com.kk.user.management.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kk.user.management.entity.User;
import com.kk.user.management.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserUnlockService {

	@Autowired
	private UserRepository userRepository;
	
	@Scheduled(fixedRate =  25000L)
	public void checkAccount() {
		log.debug("Locked account checking");
		
		List<User> users = 
				userRepository.findAllByAccountNonLockedAndLastModifiedDateIsBefore(false, 
				Timestamp.valueOf(LocalDateTime.now().minusSeconds(20)));
		
		if(users.size() > 0) {
			log.debug(users.size() +  " Locked accounts found");
			users.forEach(user -> user.setAccountNonLocked(true));
			userRepository.saveAll(users);
		}
	}
}
