package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans.TestBean3;
import com.demo.config.BeancofigClass;

public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeancofigClass.class);

		TestBean1 java1 = ctx.getBean("java1", TestBean1.class);
		System.out.printf("java1 : %s\n", java1);
		
		TestBean1 java600 = ctx.getBean("java600", TestBean1.class);
		System.out.printf("java600 : %s\n", java600);
		
		TestBean2 java2 = ctx.getBean("java2", TestBean2.class);
		System.out.printf("java2 : %s\n", java2);
		
		TestBean3 java3 = ctx.getBean("java3", TestBean3.class);
		System.out.printf("java3 : %s\n", java3);
		
		ctx.close();
	}
}
