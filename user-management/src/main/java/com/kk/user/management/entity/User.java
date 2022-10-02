package com.kk.user.management.entity;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
@Getter
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	private String username;
	private String password;
	
	@Builder.Default
	private boolean isAccountNonExpired = true;
	
	@Builder.Default
	private boolean isAccountNonLocked = true;
	
	@Builder.Default
	private boolean isCredentialsNonExpired = true;
	
	@Builder.Default
	private boolean isEnabled = true;
	
	@Singular
	@ManyToMany (cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable( name = "user_role",
			joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName = "ID")}
			)
	private Set<Role> roles;
	
	@Transient
	private Set<Authority> authorities;
	
	public Set<Authority> getAuthorities() {
		return roles.stream()
					.map(t -> t.getAuthorities())
					.flatMap(x -> x.stream())
					.collect(Collectors.toSet());
	}
	
}
