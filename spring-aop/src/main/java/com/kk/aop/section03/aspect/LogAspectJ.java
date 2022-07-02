package com.kk.aop.section03.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order (1)
public class LogAspectJ {

	@Pointcut ("execution(* com.kk.aop.section03.bean.*.*(..))")
	private void selectPointCut() {
		
	}

	@Before("selectPointCut()")
	public void beforeAdvice(){
		System.out.println("Before Advice");
	}
	
	@After("selectPointCut()")
	public void afterAdvice(){
		System.out.println("After Advice");
	}
	
	@AfterReturning(pointcut =  "selectPointCut()", returning = "retVal")
	public void afterReturningAdvice(JoinPoint jp, Object retVal){
		System.out.println("After Returning Advice for " + jp.getSignature() + ", value: " + retVal);
	}
	
	@AfterThrowing(pointcut = "selectPointCut()", throwing = "ex")
	public void afterThrowingAdvice(Exception ex){
		System.out.println("After Throwing Advice: " + ex.toString());
	}
//	
//	@Around("selectPointCut()")
//	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
//		System.out.println("Around for: " + joinPoint.toShortString());
//		joinPoint.proceed(joinPoint.getArgs());
//	}
}
