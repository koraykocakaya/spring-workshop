package com.kk.user.management.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	private String permission;
	
    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;
}
