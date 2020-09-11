package com.freekai;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, PriorityOrdered {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println("======MyImportBeanDefinitionRegistrar=======");
		System.out.println(importingClassMetadata.getClassName());
		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(Person2.class);
		registry.registerBeanDefinition("person22", bd);
		System.out.println("=============");
	}

	@Override
	public int getOrder() { // 实现PriorityOrdered接口，保证执行的先后顺序
		return 11;
	}
}
