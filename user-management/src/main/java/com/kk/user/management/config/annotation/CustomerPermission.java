package com.kk.user.management.config.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAuthority('admin') "
		+ "OR hasAuthority('authCustomer')"
		+ "AND @customAuthenticationManager.customerIdMatches(authentication,#customerId)")
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerPermission {

}
