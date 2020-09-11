package com.freekai.context;

import com.freekai.beanpp.FBeanPostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 实验一下，自己写个 AbstractApplicationContext的子类'
 * 实现 org.springframework.context.support.AbstractApplicationContext#
 * 		postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
 *
 * 	没实现结果===》fail
 */
@Component
public class MyApplicationContext extends AbstractApplicationContext implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	protected void refreshBeanFactory() throws BeansException, IllegalStateException {

	}

	@Override
	protected void closeBeanFactory() {

	}

	@Override
	public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
		System.out.println("获取");
		return (ConfigurableListableBeanFactory) applicationContext.getParentBeanFactory();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		System.out.println("1233333");
		super.postProcessBeanFactory(beanFactory);
		// 随便向 beanFactory 加一些东西
		beanFactory.addBeanPostProcessor(new FBeanPostProcessor());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
