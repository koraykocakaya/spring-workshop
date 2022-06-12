package com.kk.aop.section03.Bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspectJ {

	@Pointcut ("execution(* com.kk.aop.section03.Bean.*.*(..))")
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
//	
//	@AfterThrowing("selectPointCut()")
//	public void afterThrowingAdvice(Exception ex){
//		System.out.println("After Throwing Advice: " + ex.toString());
//	}
	
	@Around("selectPointCut()")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Around for: " + joinPoint.toShortString());
		joinPoint.proceed(joinPoint.getArgs());
	}
}
