package com.dao;

public interface UserDao {
	//update t_user set name=? where id=?
	//根据id更新具体的用户名
	void update(int id,String name);
	//执行删除
	void delete(int id);

	// 执行添加
	void insert(String username, String password);

	// 查询所有
	void findAll();

	// 登录方法
	void login(String username, String password);
}
/*
 * Dao模式 Data Access Object数据访问对象 
 * 1.新建一个dao的接口,里面声明访问的逻辑
 * 2.新建一个dao的实现类,具体实现早前定义的规则 3.直接使用实现
 * 
 * 总结
 * 1.JDBC入门
 * 2.抽取工具类
 * 3.Statement CRUD(增删改查操作)
 *   重点演练crud
 * 4.Dao模式
 *   声明与实现分开
 * 5.PrepareStatement CRUD
 *   预处理sql语句,解决上Statement出现的问题
 */