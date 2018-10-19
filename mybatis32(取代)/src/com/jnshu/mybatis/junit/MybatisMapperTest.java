package com.jnshu.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.jnshu.mybatis.mapper.UserMapper;
import com.jnshu.mybatis.pojo.User;

public class MybatisMapperTest {
	@Test
	public void testMapper() throws Exception {
		//���غ��������ļ�
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//SqlSession��������ʵ����(���ӿ�)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByID(10);
		System.out.println(user);
	}
}
