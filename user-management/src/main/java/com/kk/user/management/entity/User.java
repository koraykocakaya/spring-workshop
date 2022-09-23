package com.kk.user.management.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
@Getter
@Setter
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
	@ManyToMany (cascade = CascadeType.MERGE)
	@JoinTable( name = "user_authority",
			joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name="AUTHORITY_ID", referencedColumnName = "ID")}
			)
	private Set<Authority> authorities;
	
}
