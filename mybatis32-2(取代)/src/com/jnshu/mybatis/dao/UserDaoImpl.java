package com.jnshu.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jnshu.mybatis.pojo.User;

/**
 * Dao
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	//ע�빤��
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	//ͨ���û�id��ѯһ���û�
	public User selectUserByID(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("findUserByID", id);
	}
	//ͨ���û���ģ����ѯ
	public List<User> selectUserByUsername(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("findUserByID", id);
	}

}
