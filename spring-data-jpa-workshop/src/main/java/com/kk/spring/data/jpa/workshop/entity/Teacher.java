package com.kk.spring.data.jpa.workshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Teacher")
public class Teacher {

	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO
	)
	private Long teacherId;
	private String firstName;
	private String lastName;
	

}
