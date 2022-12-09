package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {

		// 자바 빈 설정
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);

		TestBean1 java1 = ctx.getBean(TestBean1.class);

		java1.method1();

		ctx.close();

	}
}
