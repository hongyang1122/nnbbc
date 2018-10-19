package com.jnshu.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * �û�Dao��ʵ����
 * @author Administrator
 *
 */
//@Component("userDao")//<bean id="UserDao" class="com.jnshu.spring.demo1.UserDaoImpl.java"/>
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Value("����")
	private String name;
	/*@Value("����")
	public void setName(String name) {
		this.name = name;
	}*/

	@Override
	public void save() {
		System.out.println("Dao�б����û��ķ���ִ����..."+name);
	}

}
