package com.kk.section09.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	
	@Autowired
	@Lazy
	private Person person;
	
	@Value("${productNo}")
	String productNo;
	
	public String getDescription() {
		return person.getName() + " " + productNo;
	}
	
}
