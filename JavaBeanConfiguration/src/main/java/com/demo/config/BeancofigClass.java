package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans.TestBean3;

@Configuration
public class BeancofigClass {
	
	@Bean
	public TestBean1 java1() {
		TestBean1 t1 = new TestBean1();
		return t1;
	}
	
	@Bean(name = "java600")
	public TestBean1 java500() {
		return new TestBean1();
	}
	
	@Bean
	@Lazy
	public TestBean2 java2() {
		return new TestBean2();
	}
	
	@Bean
	@Scope("prototype")
	public TestBean3 java3() {
		return new TestBean3();
	}
	
	
}
