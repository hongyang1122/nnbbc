package com.jnshu.mybatis.dao;

import com.jnshu.mybatis.pojo.User;

public interface UserDao {
	// ͨ���û�id��ѯһ���û�
	public User selectUserByID(Integer id);
}
