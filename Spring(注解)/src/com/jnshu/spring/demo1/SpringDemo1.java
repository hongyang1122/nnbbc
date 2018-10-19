package com.jnshu.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC注解开发的测试类
 * @author Administrator
 *
 */
public class SpringDemo1 {
	@Test
	//传统方式
	public void Demo1(){
		UserDaoImpl userDao=new UserDaoImpl();
		//userDao.setName("李兵");
		userDao.save();
	}
	
	@Test
	//Spring的IOC的注解方式
	public void Demo2(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}
	
	@Test
	//Spring的IOC的注解方式
	public void Demo3(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) applicationContext.getBean("userService");
		userService.save();
	}
}
