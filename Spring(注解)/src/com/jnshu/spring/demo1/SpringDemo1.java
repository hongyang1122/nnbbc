package com.jnshu.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOCע�⿪���Ĳ�����
 * @author Administrator
 *
 */
public class SpringDemo1 {
	@Test
	//��ͳ��ʽ
	public void Demo1(){
		UserDaoImpl userDao=new UserDaoImpl();
		//userDao.setName("���");
		userDao.save();
	}
	
	@Test
	//Spring��IOC��ע�ⷽʽ
	public void Demo2(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}
	
	@Test
	//Spring��IOC��ע�ⷽʽ
	public void Demo3(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) applicationContext.getBean("userService");
		userService.save();
	}
}
