package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans2.TestBean4;

@Configuration
//지정된 패키지의 Bean 클래스들의 어노테이션을 분석하여 Bean을 등록하라고 지정한다.
@ComponentScan(basePackages = "com.demo.beans2")
@ComponentScan(basePackages = "com.demo.beans3")
public class BeancofigClass {

	@Bean
	public TestBean1 java1() {
		return new TestBean1();
	}

	@Bean
	public TestBean2 java2() {
		return new TestBean2();
	}

	@Bean
	public TestBean2 java3() {
		return new TestBean2();
	}

	@Bean
	public TestBean4 java100() {
		return new TestBean4();
	}

	@Bean
	public TestBean4 java200() {
		return new TestBean4();
	}

}
