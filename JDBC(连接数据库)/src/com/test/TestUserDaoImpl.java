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
		//���뱻�ƽ�,����������˼�İ�ȫ����
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

/*Statement ��ȫ����
 *1.Statementִ��,��ʵ��ƴ��sql����.��ƴ��sql���,Ȼ��һ��ִ��.
 * ǰ����ƴ��sql���,���������������� ���ݿ�Ĺؼ���,��ôһ����Ϊ�ǹؼ���.����Ϊ����ͨ���ַ���
 *2.PrepareStatement
 * �ö�������滻ǰ���statement����
 *
 *PreparedStatement
 *�ö�������滻ǰ���Statement����
 *��Ƚ���ǰ��Statement,Ԥ�ȴ��������sql���,����ִ���﷨���,��sql�������ʹ���ʺ�ռλ�����������Ҫ�������ı���.
 *��������ı���ֵ,���ᱻ�������ַ���,��������κεĹؼ���
 */