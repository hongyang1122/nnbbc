package com.jnshu.spring.demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("customerService")//<bean id="" class="" init-method="init" destroy-method="destroy"/>
@Scope("prototype")
public class CustomerService {
	@PostConstruct//�൱��init-method
	public void init(){
		System.out.println("CustomerService����ʼ����...");
	}
	public void save(){
		System.out.println("Service��save����ִ����...");
	}
	@PreDestroy//�൱��destroy-method
	public void destroy(){
		System.out.println("CustomerService��������...");
	}
}
