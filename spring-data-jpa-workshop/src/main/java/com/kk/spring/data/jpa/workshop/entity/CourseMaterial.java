package com.kk.spring.data.jpa.workshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Entity
@Table (name = "Course_Material")
@ToString(exclude = "course")
public class CourseMaterial {

	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO
	)
	private Long courseMaterialId;
	private String url;
	
	@OneToOne(
			cascade = CascadeType.DETACH,
			fetch = FetchType.EAGER
	)
	@JoinColumn(
			name =  "course_id",
			referencedColumnName = "courseId"
	)
	private Course course;
	
}
