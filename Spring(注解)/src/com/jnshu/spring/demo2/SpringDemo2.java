package com.jnshu.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
	@Test
	public void Demo1(){
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService1=(CustomerService) applicationContext.getBean("customerService");
		System.out.println(customerService1);
		CustomerService customerService2=(CustomerService) applicationContext.getBean("customerService");
		System.out.println(customerService2);
		applicationContext.close();
	}
}
