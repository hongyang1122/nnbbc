package com.jnshu.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * XML��ע�����Ͽ���
 * @author Administrator
 *
 */
public class SpringDemo3 {
	@Test
	public void Demo1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService=(ProductService) applicationContext.getBean("productService");
		productService.save();
	}
}
