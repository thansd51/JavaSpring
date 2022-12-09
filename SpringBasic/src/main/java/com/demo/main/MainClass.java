package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.HelloWorld;

public class MainClass {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/config/beans.xml");
		
		HelloWorld hello1 = (HelloWorld)ctx.getBean("hello");
		callMethod(hello1);
		
		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);
		callMethod(hello2);
		
		ctx.close();
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
