package com.kk.user.management.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.kk.user.management.entity.Authority;
import com.kk.user.management.entity.User;
import com.kk.user.management.repository.AuthorityRepository;
import com.kk.user.management.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDataLoader implements CommandLineRunner {

	private final AuthorityRepository authorityRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	private void loadUserData() {
		Authority admin = authorityRepository.save(Authority.builder().role("ADMIN").build());
		Authority user = authorityRepository.save(Authority.builder().role("USER").build());
		Authority customer = authorityRepository.save(Authority.builder().role("CUSTOMER").build());
		
		userRepository.save(User.builder()
						.username("KorayB")
						.password(passwordEncoder.encode("12"))
						.authority(user)
						.build());
		
		userRepository.save(User.builder()
				.username("Koray")
				.password(passwordEncoder.encode("12"))
				.authority(admin)
				.build());
		
		userRepository.save(User.builder()
				.username("admin")
				.password(passwordEncoder.encode("1234"))
				.authority(customer)
				.build());
	}
	
	@Override
	public void run(String... args) throws Exception {
		if (authorityRepository.count() == 0) {
            loadUserData();
        }
	}
}
