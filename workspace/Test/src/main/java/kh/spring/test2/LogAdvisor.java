package kh.spring.test2;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.Signature;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvisor {

@Pointcut("execution(* kh.spring.test2.MembersDAO.*(..))")
public void printLog() {}

@Before("printLog()")
public void before(JoinPoint jp) {
	Signature p = jp.getSignature();
	String methodName = p.getName();
	System.out.println(methodName);
	}

}
