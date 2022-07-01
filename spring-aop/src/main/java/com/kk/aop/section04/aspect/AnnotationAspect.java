package com.kk.aop.section04.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {

	@Before("@annotation(com.kk.aop.section04.annotation.Loggable)")
	public void beforeAnnotationAdvice() {
		System.out.println("Before method call");
	}
}
