package com.kk.spring.data.jpa.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString (exclude = "courseMaterial")
@Entity
@Table (name = "Course")
public class Course {

	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO
	)
	private Long courseId;
	private String title;
	private Integer credit;
	
	@OneToOne(
			mappedBy = "course",
			fetch = FetchType.EAGER
	)
	private CourseMaterial courseMaterial;
	
	
}
