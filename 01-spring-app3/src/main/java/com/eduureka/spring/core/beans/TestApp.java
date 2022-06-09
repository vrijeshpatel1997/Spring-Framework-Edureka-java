package com.eduureka.spring.core.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {

// initialize  spring container
		
	//BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");

		
		ApplicationContext context = 	new ClassPathXmlApplicationContext("beans.xml");
		
	int beanCount =	context.getBeanDefinitionCount();
	
	System.out.println(" no of beans  with spring container = " + beanCount);
	System.out.println(" ------------------------------------------------------ ");
	
	System.out.println(" names of beans  with spring container ");
	
	String[] beanNames = context.getBeanDefinitionNames();
	


	for(String bName : beanNames) {
		

		System.out.println(bName);
		
	}
	

	}


}
