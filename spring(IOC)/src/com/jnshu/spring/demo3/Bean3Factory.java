package com.jnshu.spring.demo3;
/**
 * Bean3��ʵ������
 * @author Administrator
 *
 */
public class Bean3Factory {

	public Bean3 createBean3(){
		System.out.println("Bean3��ʵ������ִ����...");
		return new Bean3();
	}
}
