package com.ibm.springboot.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class EmployeeServiceAspect {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.ibm.springboot.demo.service.*.*(..))")//FQN
	public void serviceMethods() {
		LOG.info("a method was invoked from before Service Aspect");
	}
	
	@After("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceMethod2() {
		LOG.info("a method was invoked from Service Aspect");
		
	}
	
	@AfterReturning("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceSuccess() {
		//assignment for today
		//1. send mail from aspect advice to a specific id, use yahoo mail
		//2. pre-study spring actuator
		//3. basic understanding of microservices
		LOG.info("Data returned successfully");
	}
	
	@AfterThrowing("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceFailed() {
		LOG.info("Data could not be returned ");
	}
	
	

}
