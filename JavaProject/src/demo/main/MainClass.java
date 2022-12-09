package demo.main;

import demo.beans.HelloWorld;
import demo.beans.HelloWorldEn;
import demo.beans.HelloWorldKo;

public class MainClass {
	
	public static void main(String[] args) {
		
		HelloWorld hello1 = new HelloWorldEn();
//		hello1.sayHello();
		callMethod(hello1);
		
		HelloWorld hello2 = new HelloWorldKo();
//		hello2.sayHello();
		callMethod(hello2);
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
