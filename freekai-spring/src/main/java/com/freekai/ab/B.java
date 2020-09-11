package com.freekai.ab;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class B {

	public B(){
		System.out.println(" B实例化了");
	}

	public void testAop(){
		System.out.println("B中方法，用来测试aop");
	}
}
