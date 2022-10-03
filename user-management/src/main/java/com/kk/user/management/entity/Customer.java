package com.kk.user.management.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
@Getter
public class Customer {

	@Id
	private String id;
	
	private String name;

	@OneToMany (mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<User> users;
}
