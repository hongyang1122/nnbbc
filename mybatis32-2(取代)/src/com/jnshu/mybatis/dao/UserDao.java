package com.jnshu.mybatis.dao;

import com.jnshu.mybatis.pojo.User;

public interface UserDao {
	// 通过用户id查询一个用户
	public User selectUserByID(Integer id);
}
