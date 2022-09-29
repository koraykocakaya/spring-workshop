package com.kk.user.management.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kk.user.management.entity.Authority;
import com.kk.user.management.entity.User;
import com.kk.user.management.repository.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> {
					return new UsernameNotFoundException("Username not found");
				}
				);
		
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(),
				user.isAccountNonLocked(), convertToGrantedAuthorities(user.getAuthorities()));
	}
	
	private Collection<? extends GrantedAuthority> convertToGrantedAuthorities(Set<Authority> auths){
		if(auths != null && auths.size() > 0) {
			return 		
					auths.stream()
					 .map(x -> x.getRole())
					 .map(x -> new SimpleGrantedAuthority(x))
					 .collect(Collectors.toSet());
		}
		return new HashSet<>();
	}
	

}
