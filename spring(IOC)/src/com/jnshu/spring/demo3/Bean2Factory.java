package com.jnshu.spring.demo3;
/**
 * Bean2�ľ�̬����
 * @author Administrator
 *
 */
public class Bean2Factory {

	public static Bean2 createBean2(){
		System.out.println("Bean2Factory�з���ִ����...");
		return new Bean2();
	}
}
