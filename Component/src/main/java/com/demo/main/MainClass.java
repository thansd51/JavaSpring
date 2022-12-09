package com.demo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.beans.TestBean1;
import com.demo.beans.TestBean2;
import com.demo.beans2.TestBean3;
import com.demo.beans2.TestBean4;
import com.demo.beans3.TestBean5;
import com.demo.config.BeancofigClass;

public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeancofigClass.class);

		TestBean1 java1 = ctx.getBean(TestBean1.class);
		System.out.printf("java1 : %s\n", java1);
		
		TestBean1 java111 = ctx.getBean("java1", TestBean1.class);
		System.out.printf("java111 : %s\n", java111);
		
		TestBean2 java2 = ctx.getBean("java2", TestBean2.class);
		System.out.printf("java2 : %s\n", java2);
		
		TestBean2 java3 = ctx.getBean("java3", TestBean2.class);
		System.out.printf("java3 : %s\n", java3);
		
		System.out.println("-------------------------------");
		
		TestBean3 java4 = ctx.getBean(TestBean3.class);
		System.out.printf("java4 : %s\n", java4);
		
		TestBean4 java5 = ctx.getBean("bean4", TestBean4.class);
		System.out.printf("java5 : %s\n", java5);
		
		TestBean4 java100 = ctx.getBean("java100", TestBean4.class);
		System.out.printf("java100 : %s\n", java100);
		
		TestBean4 java200 = ctx.getBean("java200", TestBean4.class);
		System.out.printf("java200 : %s\n", java200);
		
		System.out.println("-------------------------------");
		
		TestBean5 java500 = ctx.getBean(TestBean5.class);
		System.out.printf("java500 : %s\n", java500);

		ctx.close();
	}
}
