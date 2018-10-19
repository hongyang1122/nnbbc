package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.UserDao;
import com.util.JDBCUtil;

//定义操作数据库的方法
public class UserDaoImpl implements UserDao {

	@Override
	public void findAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 获取链接对象
			conn = JDBCUtil.getConn();
			// 创建statement对象
			st = conn.createStatement();
			String sql = "select*from t_user";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String userName = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(userName + "=" + password);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, st, conn);
		}
	}

	@Override
	public void login(String username, String password) {
		Connection conn =null;
		Statement st =null;
		ResultSet rs =null; 
		try {
			//获取链接对象
			conn = JDBCUtil.getConn();
			//创建statement对象
			String sql="select*from t_user where username=? and password=?";
			//预先对sql语句执行语法的校验,?对应的内容后面不管传递什么进来,都把他看成是字符串
			PreparedStatement ps = conn.prepareStatement(sql);
			//?对应的索引从1开始
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			//st = conn.createStatement();
			//*select*from t_user where username='admin' and password='10086'
			//String sql2 = "select*from t_user where username='"+ username +"' and password='"+ password +"'";
			//rs = st.executeQuery(sql2);
			if(rs.next()){
				System.out.println("登陆成功");
			}else{
				System.out.println("登陆失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(rs, st, conn);
		}
	}

	@Override
	public void insert(String username, String password){
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = JDBCUtil.getConn();
			String sql="insert into t_user values(null,?,?)";
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, username);
			ps.setString(2, password);
			int result=ps.executeUpdate();
			if(result>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(ps, conn);
		}
	}
	
	@Override
	public void delete(int id){
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = JDBCUtil.getConn();
			String sql="delete from t_user where id=?";
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			if(result>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(ps, conn);
		}
	}

	@Override
	public void update(int id, String name) {
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = JDBCUtil.getConn();
			String sql="update t_user set username=? where id=?";
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, name);
			ps.setInt(2, id);
			int result=ps.executeUpdate();
			if(result>0){
				System.out.println("更新成功");
			}else{
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(ps, conn);
		}
	}	
}
