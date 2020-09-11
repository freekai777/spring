package com.freekai;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportBeanDefinitionRegistrar2 implements ImportBeanDefinitionRegistrar, PriorityOrdered {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println("======MyImportBeanDefinitionRegistrar2=======");
	}

	@Override
	public int getOrder() {
		return 12;
	}
}
