package com.freekai;

import com.freekai.ab.A;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(AppConfig.class);
/*		Resource resource = aca.getResource("classpath:testResource.properties");
		System.out.println(resource.exists());*/
//		Animal animal = aca.getBean(Animal.class);
		System.out.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<");
		for (String beanDefinitionName : aca.getBeanDefinitionNames()) {
			// System.out.println(beanDefinitionName);
		}
		System.out.println(">>>>>>>>>>>>>>>><<<<<<<<<<<<<<<");
		A a = (A) aca.getBean("a");
		a.testAopMethod();
	}
}
