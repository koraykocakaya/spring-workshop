package com.kk.aop.section04.bean;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CartService {

	public BigDecimal getPrice() {
		return BigDecimal.ONE;
	}
	
}

