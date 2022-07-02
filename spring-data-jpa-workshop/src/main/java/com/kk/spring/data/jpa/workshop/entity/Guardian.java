package com.kk.spring.data.jpa.workshop.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
	@AttributeOverride(
			name = "name",
			column = @Column(name = "guardian_name")
	)
})
public class Guardian {

	private String name;
	private String gEmail;
	private String gMobile;

}
