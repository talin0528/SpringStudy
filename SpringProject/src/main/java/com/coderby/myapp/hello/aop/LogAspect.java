package com.coderby.myapp.hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Pointcut(value="execution(* com.coderby..*.sayHello(..))")
	private void helloPointcut() {}
	
	@Pointcut(value="execution(* com.coderby..*.sayGoodbye(..))")
	private void goodbyePointcut() {}
	
	@Before("helloPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[LOG: Before] 메서드 이름: " + signature.getName());
	}
	
	@After("helloPointcut()")
	public void afterLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[LOG: After] 메서드 이름: " + signature.getName());
	}
	
	@AfterReturning(pointcut="helloPointcut()", returning="message")
	public Object afterReturning(JoinPoint joinPoint, String message) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[LOG: AfterReturning] 메서드 이름: " + signature.getName());
		return message;
	}
	
	@AfterThrowing(pointcut="goodbyePointcut()", throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[LOG: AfterThrowing] 메서드 이름: " + signature.getName());
	}
	
	@Around("execution(* com.coderby..*.*(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		System.out.println("[LOG: Around] Before: " + methodName + " time check start");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch(Exception e) {
			System.out.println("[LOG: Around] Exception: " + methodName);
		} finally {
			System.out.println("[LOG: Around] Finally: " + methodName);
		}
		
		long endTime = System.nanoTime();
		System.out.println("[LOG: Around] After: " + methodName + " time check end");
		System.out.println("[LOG: Around] " + methodName + " Processing time is " + (endTime - startTime) + "ns");
		return result;
	}
}
