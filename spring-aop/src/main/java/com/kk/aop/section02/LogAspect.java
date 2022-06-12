package com.kk.aop.section02;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

	public void beforeAdvice() {
		System.out.println("Before method call");
	}

	public void afterAdvice() {
		System.out.println("After method call");
	}

	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning:" + retVal.toString());
	}

	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}
	
	public void beforeNameAdvice() {
		System.out.println("Before getName() advice called");
	}
	
	public Object aroundNameAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Around getName() begin called");
		long beginTime = System.currentTimeMillis();
		
		Object o = jp.proceed();

		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for " + jp.toShortString() + ": " + (endTime - beginTime) + " ms");
		System.out.println("Around getName() after called");
		return o;
	}
}
