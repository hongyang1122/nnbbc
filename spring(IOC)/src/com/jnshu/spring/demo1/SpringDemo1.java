package com.jnshu.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Spring����
 * @author Administrator
 *
 */
public class SpringDemo1 {
	@Test
	/**
	 * ��ͳ��ʽ�ĵ���
	 */
	public void Demo1(){
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setName("����");
		userDao.save();
	}
	
	@Test
	/**
	 * Spring�ķ�ʽ�ĵ���
	 */
	public void Demo2(){
		//����Spring����
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.save();
		
	}
	
	@Test
	/**
	 * ���ش����ϵ������ļ�
	 */
	public void Demo3(){
		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("D:\\applicationContext.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}

}
