package com.kk.user.management.entity;

import java.sql.Timestamp;
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
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements UserDetails, CredentialsContainer{ 
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	private String username;
	private String password;
	
	@Builder.Default
	private boolean accountNonExpired = true;
	
	@Builder.Default
	private boolean accountNonLocked = true;
	
	@Builder.Default
	private boolean credentialsNonExpired = true;
	
	@Builder.Default
	private boolean enabled = true;
	
	@Singular
	@ManyToMany (cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable( name = "user_role",
			joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName = "ID")}
			)
	private Set<Role> roles;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	public Set<GrantedAuthority> getAuthorities() {
		return roles.stream()
					.map(t -> t.getAuthorities())
					.flatMap(x -> x.stream())
					.map(x -> new SimpleGrantedAuthority(x.getPermission()))
					.collect(Collectors.toSet());
	}
	
	@Override
	public void eraseCredentials() {
		this.password = null;
	}
	
	@CreationTimestamp
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
}
