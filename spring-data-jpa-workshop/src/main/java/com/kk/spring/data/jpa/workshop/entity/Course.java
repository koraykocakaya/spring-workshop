package com.kk.spring.data.jpa.workshop.entity;

import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString (exclude = "courseMaterial")
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
	
	@ManyToOne(
		fetch = FetchType.EAGER,
		cascade = CascadeType.MERGE
	)
	@JoinColumn(
			name =  "teacher_id",
			referencedColumnName = "teacherId"
	)
	private Teacher teacher;
	
	@ManyToMany(
			cascade = CascadeType.ALL
	)
	@JoinTable(
			name = "student_course_map",
			joinColumns = @JoinColumn(
				referencedColumnName = "courseId",
				name = "course_id"
			),
			inverseJoinColumns = @JoinColumn(
				referencedColumnName = "studentId",
				name = "student_id"	
			)
	)
	private List<Student> students;
	
	
}
