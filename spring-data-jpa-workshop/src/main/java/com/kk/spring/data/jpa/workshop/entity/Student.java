package com.kk.spring.data.jpa.workshop.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
		name="Student",
		uniqueConstraints = @UniqueConstraint(
			name="emailid_unique",
			columnNames = "email_address"
		)
)
public class Student {

	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO
	)
	private Long studentId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(
			name = "email_address",
			nullable = false
	)
	private String emailId;
	
	@Embedded
	private Guardian guardian;
	
//	private String guardianName;
//	
//	private String guardianEmail;
//	
//	private String guardianMobile;
	
}
