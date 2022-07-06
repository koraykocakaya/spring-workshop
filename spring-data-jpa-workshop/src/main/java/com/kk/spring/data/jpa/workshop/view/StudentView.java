package com.kk.spring.data.jpa.workshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentView {

	private String lastName;
	private Integer count;
}
