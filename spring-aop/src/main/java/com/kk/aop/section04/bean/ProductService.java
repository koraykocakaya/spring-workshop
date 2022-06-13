package com.kk.aop.section04.bean;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.kk.aop.section04.annotation.Loggable;

@Component
public class ProductService {

	@Loggable
	public BigDecimal getPrice() {
		return BigDecimal.TEN;
	}
}
