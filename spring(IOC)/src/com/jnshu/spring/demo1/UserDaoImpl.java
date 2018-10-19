package com.jnshu.spring.demo1;
/**
 * 业务层实现类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void save() {
		System.out.println("UserService执行了..."+name);
	}
	
}
