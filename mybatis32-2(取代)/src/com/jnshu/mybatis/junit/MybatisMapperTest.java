package com.jnshu.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.jnshu.mybatis.mapper.OrderMapper;
import com.jnshu.mybatis.mapper.UserMapper;
import com.jnshu.mybatis.pojo.Orders;
import com.jnshu.mybatis.pojo.QueryVo;
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
	@Test
	public void testMapperQueryVo() throws Exception {
		//���غ��������ļ�
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//SqlSession��������ʵ����(���ӿ�)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo=new QueryVo();
		User user=new User();
		user.setUsername("��");
		vo.setUser(user);		
		List<User> us = userMapper.findUserByQueryVo(vo);
		for (User u : us) {
			System.out.println(u);
		}
		
	}
	@Test
	public void testMapperQueryVoCount() throws Exception {
		//���غ��������ļ�
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//SqlSession��������ʵ����(���ӿ�)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
		Integer i = userMapper.countUser();
		System.out.println(i);
		
	}
	//��ѯ������order��������
	@Test
	public void testOrderList() throws Exception {
		//���غ��������ļ�
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> ordersList = mapper.selectOrdersList();
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}
	//�����Ա�����ֲ�ѯ�û�
	@Test
	public void testfindUserBySexAndUsername() throws Exception {
		//���غ��������ļ�
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setSex("��");
		user.setUsername("��Ӿ�");
		List<User> users = userMapper.selectUserBySexAndUsername(user);
		for (User user2 : users) {
			System.out.println(user2);
		}
		
	}
	//���ID
	@Test
	public void testfindUserIDs() throws Exception {
		//���غ��������ļ�
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> ids=new ArrayList<>();//3��    2��
		ids.add(24);
		ids.add(25);
		ids.add(26);            
		QueryVo vo=new QueryVo();
		vo.setIdsList(ids);//3��    2��
		//List<User> users = userMapper.selectUserByIDs(vo);//1��
		/*Integer[] ids=new Integer[3];
		ids[0]=24;
		ids[1]=25;              
		ids[2]=26;//1��*/
		List<User> users = userMapper.selectUserByIDs(ids);
		for (User user2 : users) {
			System.out.println(user2);
		}
		
	}
	//һ��һӳ��
	@Test
	public void testOrderLists() throws Exception {
		//���غ��������ļ�
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//SqlSession��������ʵ����(���ӿ�)
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> selectOrdersList = orderMapper.selectOrders();
		for (Orders orders : selectOrdersList) {
			System.out.println(orders);
		}
	}
	//һ�Զ�ӳ��
	@Test
	public void testUserList() throws Exception {
		//���غ��������ļ�
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//SqlSession��������ʵ����(���ӿ�)
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<User> users = orderMapper.selectUserList();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
