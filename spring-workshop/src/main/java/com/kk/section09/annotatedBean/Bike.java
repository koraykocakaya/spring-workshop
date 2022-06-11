package com.kk.section09.annotatedBean;

import org.springframework.stereotype.Component;

@Component("bike")
public class Bike implements Vehicle{

	@Override
	public double getSpeed() {
		return 10d;
	}
}
