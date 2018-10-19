package com.jnshu.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Spring入门
 * @author Administrator
 *
 */
public class SpringDemo1 {
	@Test
	/**
	 * 传统方式的调用
	 */
	public void Demo1(){
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setName("王东");
		userDao.save();
	}
	
	@Test
	/**
	 * Spring的方式的调用
	 */
	public void Demo2(){
		//创建Spring工厂
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.save();
		
	}
	
	@Test
	/**
	 * 加载磁盘上的配置文件
	 */
	public void Demo3(){
		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("D:\\applicationContext.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}

}
