package com.freekai;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 自定义类，实现 WebApplicationInitializer ,加载配置文件
 */
public class FreekaiWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCxt){
//		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(AppConfig.class);

		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(AppConfig.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("DispatcherServlet", dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");// servlet-mapping

	}
}
