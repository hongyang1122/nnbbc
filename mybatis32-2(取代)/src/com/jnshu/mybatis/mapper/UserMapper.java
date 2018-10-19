package com.jnshu.mybatis.mapper;

import java.util.List;

import com.jnshu.mybatis.pojo.QueryVo;
import com.jnshu.mybatis.pojo.User;

public interface UserMapper {
	//遵循四个原则
	//接口方法名==User.xml中id名
	//返回值类型 与Mapper.xml文件中返回值类型要一致
	//方法的入参类型要与Mapper.xml文件中入参的类型要一致
	//命名空间绑定此接口
	public User findUserByID(Integer id);
	public List<User> findUserByQueryVo(QueryVo vo);
	//查询数据条数
	public Integer countUser();
	//根据性别和名字查询用户  User user Map map map.put(username,aabbc).put(id,1).put...
	public List<User> selectUserBySexAndUsername(User user);
	//根据id信息查询多个用户信息
	//public List<User> selectUserByIDs(Integer[] ids);//1号    三种方案
	public List<User> selectUserByIDs(List<Integer> ids);//2号
	//public List<User> selectUserByIDs(QueryVo vo);//3号
}
