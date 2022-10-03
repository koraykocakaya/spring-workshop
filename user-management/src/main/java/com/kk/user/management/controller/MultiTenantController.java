package com.kk.user.management.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kk.user.management.config.annotation.CustomerPermission;

@RestController
public class MultiTenantController {
	
	@PreAuthorize("hasAuthority('admin') "
			+ "OR hasAuthority('authCustomer')"
			+ "AND @customAuthenticationManager.customerIdMatches(authentication,#customerId) ")
	@GetMapping("/multiExample")
	public String getCustomerId(@RequestParam("customerId") String customerId) {
		return customerId;
	}
	
	@CustomerPermission
	@GetMapping("/multiExampleAnnot")
	public String getCustomerIdWithAnnotation(@RequestParam("customerId") String customerId) {
		return customerId;
	}
}
