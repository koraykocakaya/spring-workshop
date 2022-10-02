package com.kk.user.management.runner;

import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.kk.user.management.entity.Authority;
import com.kk.user.management.entity.Role;
import com.kk.user.management.entity.User;
import com.kk.user.management.repository.AuthorityRepository;
import com.kk.user.management.repository.RoleRepository;
import com.kk.user.management.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDataLoader implements CommandLineRunner {

	private final RoleRepository roleRepository;
	private final AuthorityRepository authorityRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	private void loadUserData() {
		Authority auth1 = authorityRepository.save(Authority.builder().permission("auth1").build());
		Authority auth2 = authorityRepository.save(Authority.builder().permission("auth2").build());
		Authority auth3 = authorityRepository.save(Authority.builder().permission("auth3").build());
		
		Role adminRole = roleRepository.save(Role.builder().name("admin").build());
		Role customerRole = roleRepository.save(Role.builder().name("customer").build());
		Role userRole = roleRepository.save(Role.builder().name("user").build());
		
		adminRole.setAuthorities(Set.of(auth1, auth2, auth3));
		customerRole.setAuthorities(Set.of(auth1, auth2));
		userRole.setAuthorities(Set.of(auth1));
		
		roleRepository.saveAll(Arrays.asList(adminRole, customerRole, userRole));
		
//		Authority admin = authorityRepository.save(Authority.builder().role("ROLE_ADMIN").build());
//		Authority user = authorityRepository.save(Authority.builder().role("ROLE_USER").build());
//		Authority customer = authorityRepository.save(Authority.builder().role("ROLE_CUSTOMER").build());
		
		userRepository.save(User.builder()
						.username("KorayB")
						.password(passwordEncoder.encode("12"))
						.role(customerRole)
						.build());
		
		userRepository.save(User.builder()
				.username("Koray")
				.password(passwordEncoder.encode("12"))
				.role(userRole)
				.build());
		
		userRepository.save(User.builder()
				.username("admin")
				.password(passwordEncoder.encode("1234"))
				.role(adminRole)
				.build());
	}
	
	@Override
	public void run(String... args) throws Exception {
		if (authorityRepository.count() == 0) {
            loadUserData();
        }
	}
}
