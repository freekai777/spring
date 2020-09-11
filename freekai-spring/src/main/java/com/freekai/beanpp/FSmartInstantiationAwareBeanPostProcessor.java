package com.freekai.beanpp;

import com.freekai.ab.B;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * 能影响到spring 实例化A 构造函数public A(B b){ }的推断==>用于自动注入的类 输出如：  A constructor with b print-------
 *
 */
@Component
public class FSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		if(Objects.equals("a",beanName)){
			try {
				Constructor<?> declaredConstructor4Autowired = beanClass.getDeclaredConstructor(B.class);
				Constructor<?> declaredConstructor = beanClass.getDeclaredConstructor(String.class);
				return new Constructor<?>[]{declaredConstructor, declaredConstructor4Autowired};
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}

		return beanClass.getDeclaredConstructors();
	}
}
