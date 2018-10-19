package com.test;

import org.junit.Test;

import com.dao.UserDao;
import com.impl.UserDaoImpl;

public class TestUserDaoImpl {
	@Test
	public void testFindAll() {
		UserDao dao = new UserDaoImpl();
		dao.findAll();
	}

	@Test
	public void testLogin() {
		UserDao dao = new UserDaoImpl();
		dao.login("admin", "10086");
		//dao.login("admin", "10088' or '1=1");
		//密码被破解,出现了有意思的安全问题
		//select*from t_user where username='admin' and password='10088' or '1'
	}
	
	@Test
	public void testInsert() {
		UserDao dao = new UserDaoImpl();
		dao.insert("talorswift","911");		
	}

	@Test
	public void testDelete() {
		UserDao dao = new UserDaoImpl();
		dao.delete(4);	
	}
	
	@Test
	public void testUpdate() {
		UserDao dao = new UserDaoImpl();
		dao.update(2,"sia");	
	}
}

/*Statement 安全问题
 *1.Statement执行,其实是拼接sql语句的.先拼接sql语句,然后一起执行.
 * 前面先拼接sql语句,如果变量里面带有了 数据库的关键字,那么一并认为是关键字.不认为是普通的字符串
 *2.PrepareStatement
 * 该对象就是替换前面的statement对象
 *
 *PreparedStatement
 *该对象就是替换前面的Statement对象
 *相比较以前的Statement,预先处理给定的sql语句,对其执行语法检查,在sql语句里面使用问号占位符来替代后续要传进来的变量.
 *后面进来的变量值,将会被看成是字符串,不会产生任何的关键字
 */