package com.jnshu.mybatis.mapper;

import com.jnshu.mybatis.pojo.User;

public interface UserMapper {
	//遵循四个原则
	//接口方法名==User.xml中id名
	//返回值类型 与Mapper.xml文件中返回值类型要一致
	//方法的入参类型要与Mapper.xml文件中入参的类型要一致
	//命名空间绑定此接口
	public User findUserByID(Integer id);
}
