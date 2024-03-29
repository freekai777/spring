package com.freekai;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;

public class SpringApplicationWithEmbedTomcat {

	public static void main(String[] args) throws Exception {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8091);
		Context context=tomcat.addContext("/",System.getProperty("java.io.tmpdir"));
		// 注册listener
		context.addLifecycleListener((LifecycleListener)Class.forName(tomcat.getHost().getConfigClass()).newInstance());
		tomcat.start();
		tomcat.getServer().await();
	}
}
