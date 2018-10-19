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
	//注入工厂
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	//通过用户id查询一个用户
	public User selectUserByID(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("findUserByID", id);
	}
	//通过用户名模糊查询
	public List<User> selectUserByUsername(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("findUserByID", id);
	}

}
