package com.jurdox.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/jurdox/spring/beans/beans.xml");
		
		Camera camera = (Camera) context.getBean("camera");
		
		try {
			camera.snap();
		} catch (Exception e) {
			System.out.println("Camera exception: " + e);
		}
		
		context.close();
	}	
}
