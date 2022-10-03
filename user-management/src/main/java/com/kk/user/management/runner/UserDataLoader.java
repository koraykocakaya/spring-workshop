package com.kk.user.management.runner;

import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.kk.user.management.entity.Authority;
import com.kk.user.management.entity.Customer;
import com.kk.user.management.entity.Role;
import com.kk.user.management.entity.User;
import com.kk.user.management.repository.AuthorityRepository;
import com.kk.user.management.repository.CustomerRepository;
import com.kk.user.management.repository.RoleRepository;
import com.kk.user.management.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDataLoader implements CommandLineRunner {

	private final CustomerRepository customerRepository;
	private final RoleRepository roleRepository;
	private final AuthorityRepository authorityRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	private void loadUserData() {
		
		
		Authority authAdmin = authorityRepository.save(Authority.builder().permission("admin").build());
		Authority authCustomer = authorityRepository.save(Authority.builder().permission("authCustomer").build());
		Authority auth1 = authorityRepository.save(Authority.builder().permission("auth1").build());
		Authority auth2 = authorityRepository.save(Authority.builder().permission("auth2").build());
		Authority auth3 = authorityRepository.save(Authority.builder().permission("auth3").build());
		
		
		Role adminRole = roleRepository.save(Role.builder().name("admin").build());
		Role customerRole = roleRepository.save(Role.builder().name("customer").build());
		Role userRole = roleRepository.save(Role.builder().name("user").build());
		
		adminRole.setAuthorities(Set.of(auth1, auth2, auth3, authAdmin));
		customerRole.setAuthorities(Set.of(auth1, auth2, authCustomer));
		userRole.setAuthorities(Set.of(auth1));
		
		roleRepository.saveAll(Arrays.asList(adminRole, customerRole, userRole));
		
		Customer customer1 = Customer.builder()
								  	 .id("1")
								  	 .name("customer1")
								  	 .build();
		
		Customer customer2 = Customer.builder()
			  	 					 .id("2")
			  	 					 .name("customer2")
			  	 					 .build();
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		
//		Authority admin = authorityRepository.save(Authority.builder().role("ROLE_ADMIN").build());
//		Authority user = authorityRepository.save(Authority.builder().role("ROLE_USER").build());
//		Authority customer = authorityRepository.save(Authority.builder().role("ROLE_CUSTOMER").build());
		
		userRepository.save(User.builder()
								.username("KorayB")
								.password(passwordEncoder.encode("12"))
								.role(customerRole)
								.customer(customer1)
								.build());
		
		userRepository.save(User.builder()
								.username("KorayB2")
								.password(passwordEncoder.encode("12"))
								.role(customerRole)
								.customer(customer2)
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
