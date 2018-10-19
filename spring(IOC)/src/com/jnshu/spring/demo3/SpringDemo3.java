package com.jnshu.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean��ʵ�����ķ�ʽ
 * @author Administrator
 *
 */
public class SpringDemo3 {

	@Test
	/**
	 * �޲������췽��
	 */
	public void Demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
	}
	
	@Test
	/**
	 * ��̬����ʵ����
	 */
	public void Demo2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
		System.out.println(bean2);
	}
	
	@Test
	/**
	 * ʵ������ʵ����
	 */
	public void Demo3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
		System.out.println(bean3);
	}
}
