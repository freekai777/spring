package com.freekai.ab;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ImportResource("classpath:beans.xml") // 导入xml等外部配置文件
public class A implements BeanNameAware, InitializingBean {

/*	@Autowired
	B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}*/

	private B b;

	public A() {
		System.out.println(" a constructor...");
	}

	public A(String tt) {
		System.out.println(" a constructor with a java.lang.String param...");
	}

	public A(B b){
		this.b = b;
		System.out.println(" A constructor with b print-------");
	}

	@Value("${free}")
	private String free;

	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	public void testAopMethod(){
		System.out.println("====test aop method===");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(" A类执行 BeanNameAware 中的setBeanName 方法--");
	}

	public void printB(){
		System.out.println(this.b);
		b.testAop();
		aopMethodTest1();
	}

	public void aopMethodTest1(){
		System.out.println("aopMethodTest1---in class A");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("A类 afterPropertiesSet 方法");
	}
}
