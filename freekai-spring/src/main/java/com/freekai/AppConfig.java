package com.freekai;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.freekai"})
//@Import({MyImportSelector.class})
@EnableAspectJAutoProxy
@EnableWebMvc
public class AppConfig {
}
