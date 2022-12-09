package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.TestBean;



public class MainClass {
	
	public static void main(String[] args) {
		
		test1();
	}

	public static void test1() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
		
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t1 : %s\n", t1);
		
		TestBean t2 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
		
		ctx.close();
	}
}
