package com.freekai.beanpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FBeanPostProcessor implements BeanPostProcessor , BeanFactoryAware, Ordered {

	public FBeanPostProcessor() {
		System.out.println("FBeanPostProcessor 构造函数");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(Objects.equals("a",beanName))
			System.out.println(" FBeanPostProcessor before---");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(Objects.equals("a",beanName))
			System.out.println(" FBeanPostProcessor after---");
		return bean;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(" set beanFactory....");
	}

	@Override
	public int getOrder() {
		return 20;
	}
}
