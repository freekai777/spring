package com.freekai.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component // 声明注册进spring容器
public class MyAspect {

	@Pointcut("execution(* com.freekai.ab.*.*(..))")
	public void point(){

	}

	@Before("point()")
	public void before(){
		System.out.println("before...");
	}

}
