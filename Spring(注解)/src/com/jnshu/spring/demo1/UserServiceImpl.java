package com.jnshu.spring.demo1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")//<bean id="UserService" class="com.jnshu.spring.demo1.UserServiceImpl"/>
public class UserServiceImpl implements UserService {
	//注入Dao
	//@Autowired
	//@Qualifier(value="userDao")
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public void save() {
		System.out.println("UserSerrvice的save方法执行了...");
		userDao.save();
	}

}
