package com.freekai;


import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

//@Component
//@Import(value = { MyImportBeanDefinitionRegistrar.class, MyImportBeanDefinitionRegistrar2.class})
public class Person {

	public Person() {
		System.out.println(" person constructor...");
	}
}
