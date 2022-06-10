package com.kk.section9;
	
import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(value = ApplicationHelperConfig.class)
public class ApplicationConfig {

	@Bean (initMethod = "init", destroyMethod = "destroy")
	@Scope("prototype")
	public Employee getEmployee(){
		return new Employee("Ahmet", 30, BigDecimal.TEN);
	}
	
	@Bean ("employeeBean2")
	public Employee getEmployee2(){
		return new Employee("Ahmet2", 32, BigDecimal.ONE);
	}
}
