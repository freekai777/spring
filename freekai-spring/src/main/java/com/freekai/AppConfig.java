package com.freekai;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.freekai"})
//@Import({MyImportSelector.class})
@EnableAspectJAutoProxy
public class AppConfig {
}
