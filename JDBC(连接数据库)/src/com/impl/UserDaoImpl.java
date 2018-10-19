package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.UserDao;
import com.util.JDBCUtil;

//����������ݿ�ķ���
public class UserDaoImpl implements UserDao {

	@Override
	public void findAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// ��ȡ���Ӷ���
			conn = JDBCUtil.getConn();
			// ����statement����
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
			//��ȡ���Ӷ���
			conn = JDBCUtil.getConn();
			//����statement����
			String sql="select*from t_user where username=? and password=?";
			//Ԥ�ȶ�sql���ִ���﷨��У��,?��Ӧ�����ݺ��治�ܴ���ʲô����,�������������ַ���
			PreparedStatement ps = conn.prepareStatement(sql);
			//?��Ӧ��������1��ʼ
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			//st = conn.createStatement();
			//*select*from t_user where username='admin' and password='10086'
			//String sql2 = "select*from t_user where username='"+ username +"' and password='"+ password +"'";
			//rs = st.executeQuery(sql2);
			if(rs.next()){
				System.out.println("��½�ɹ�");
			}else{
				System.out.println("��½ʧ��");
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
			//��ռλ����ֵ
			ps.setString(1, username);
			ps.setString(2, password);
			int result=ps.executeUpdate();
			if(result>0){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
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
			//��ռλ����ֵ
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			if(result>0){
				System.out.println("ɾ���ɹ�");
			}else{
				System.out.println("ɾ��ʧ��");
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
			//��ռλ����ֵ
			ps.setString(1, name);
			ps.setInt(2, id);
			int result=ps.executeUpdate();
			if(result>0){
				System.out.println("���³ɹ�");
			}else{
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(ps, conn);
		}
	}	
}
