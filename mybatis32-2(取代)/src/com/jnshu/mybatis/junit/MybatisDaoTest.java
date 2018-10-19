package com.jnshu.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.jnshu.mybatis.dao.UserDao;
import com.jnshu.mybatis.dao.UserDaoImpl;
import com.jnshu.mybatis.pojo.User;

public class MybatisDaoTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception {
		//加载核心配置文件
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void testDao() throws Exception {
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserByID(27);
		System.out.println(user);
	}
}
