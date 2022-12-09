package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = { "com.demo.beans", "com.demo.advisor" })
@EnableAspectJAutoProxy
public class BeanConfigClass {

}
