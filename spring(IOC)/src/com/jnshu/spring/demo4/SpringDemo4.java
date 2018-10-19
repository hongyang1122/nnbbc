package com.jnshu.spring.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ����ע��ķ�ʽ
 * @author Administrator
 *
 */
public class SpringDemo4 {
	@Test
	/**
	 * ���췽����ʽ������ע��
	 */
	public void Demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car=(Car) applicationContext.getBean("car");
		System.out.println(car);
	}
	
	@Test
	/**
	 * set������ʽ������ע��
	 */
	public void Demo2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car2 car2=(Car2) applicationContext.getBean("car2");
		System.out.println(car2);
	}
	
	@Test
	/**
	 * set����ע����������
	 */
	public void Demo3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee employee=(Employee) applicationContext.getBean("employee");
		System.out.println(employee);
	}
}
