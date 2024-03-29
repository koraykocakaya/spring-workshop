package com.kk.user.management.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@Singular
	@ManyToMany (cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinTable( name = "role_authority",
			joinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name="AUTHORITY_ID", referencedColumnName = "ID")}
			)
	private Set<Authority> authorities;
	
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;	

}
