package com.jnshu.spring.demo2;

public class CustomerDaoImpl implements CustomerDao {
	public void setup(){
		System.out.println("CustomerDaoImpl����ʼ����...");
	}

	@Override
	public void save() {
		System.out.println("CustomerDaoImpl��save����ִ����...");
	}
	
	public void destroy(){
		System.out.println("CustomerDaoImpl��������...");
	}
	
}
