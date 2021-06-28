package com.freekai.env;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 自定义spring环境配置类
 */
@Component
public class MyEnvironmentPostProcessor implements EnvironmentAware {

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("Env:"+environment);
	}
}
