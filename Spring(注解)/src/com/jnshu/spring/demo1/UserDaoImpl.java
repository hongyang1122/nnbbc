package com.jnshu.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 用户Dao的实现类
 * @author Administrator
 *
 */
//@Component("userDao")//<bean id="UserDao" class="com.jnshu.spring.demo1.UserDaoImpl.java"/>
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Value("王东")
	private String name;
	/*@Value("王东")
	public void setName(String name) {
		this.name = name;
	}*/

	@Override
	public void save() {
		System.out.println("Dao中保存用户的方法执行了..."+name);
	}

}
