package com.freekai.beanpp;

import com.freekai.ab.B;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FreekaiBeanPostProcessor implements BeanPostProcessor, Ordered {

	/**
	 * 在BeanPostProcessor中注入的bean，会和BeanPostProcessor的实现类当做特殊的bean一起先加载和实例化，
	 * aop代理也是通过#AnnotationAwareAspectJAutoProxyCreator(本质上是BeanPostProcessor的实现类，即bean后置处理器)，
	 * 由于 @Autowired的 其他bean会先于别的bean执行， 故不会给注入的bean进行aop代理。
	 * 实操后发现确实如此，注入的bean中的方法不会被aop拦截到，控制台也有输出
	 * [信息: Bean 'b' of type [com.freekai.ab.B] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)]
	 *
	 * 官网中原文如下：
	 *
	 *  https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-extension-bpp
	 *
	 *  Classes that implement the BeanPostProcessor interface are special and are treated differently by the container.
	 *  All BeanPostProcessor instances and beans that they directly reference are instantiated on startup,
	 *  as part of the special startup phase of the ApplicationContext. Next, all BeanPostProcessor instances are registered
	 *  in a sorted fashion and applied to all further beans in the container.
	 *  Because AOP auto-proxying is implemented as a BeanPostProcessor itself,
	 *  neither BeanPostProcessor instances nor the beans they directly reference are eligible for auto-proxying and, thus,
	 *  do not have aspects woven into them.
	 *
	 * For any such bean, you should see an informational log message: Bean someBean is not eligible for getting processed by all BeanPostProcessor
	 * interfaces (for example: not eligible for auto-proxying).
	 *
	 * I
	 *
	 */
	@Autowired
	B b;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(Objects.equals("a",beanName)){
			System.out.println("---FreekaiBeanPostProcessor--postProcess【Before】Initialization--，beanName:"+ beanName);
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(Objects.equals("a",beanName)) {
			System.out.println("---FreekaiBeanPostProcessor--postProcess【After】Initialization--，beanName:" + beanName);
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 10;
	}
}
