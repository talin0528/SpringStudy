package com.coderby.myapp.hello.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		System.out.println("[LOG] Before: " + methodName + " time check start");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch(Exception e) {
			System.out.println("[LOG] Exception: " + methodName);
		} finally {
			System.out.println("[LOG] Finally: " + methodName);
		}
		
		long endTime = System.nanoTime();
		System.out.println("[LOG] After: " + methodName + " time check end");
		System.out.println("[LOG] " + methodName + " Processing time is " + (endTime - startTime) + "ns");
		return result;
	}
}
