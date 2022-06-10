package com.kk.section9.annotatedBean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Car implements Vehicle {

	@Override
	public double getSpeed() {
		return 100d;
	}
}
