package com.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static String driverClass = null;
	static String url = null;
	static String name = null;
	static String password = null;
	static {
		try {
			// ����һ���������ö���
			Properties properties = new Properties();
			InputStream is = new FileInputStream("jdbc.properties");
			// ʹ���������ȥ��ȡsrc���µ���Դ�ļ�
			// InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			// ����������
			properties.load(is);
			// ��ȡ����
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
		} catch (Exception e) {// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * ��ȡ���Ӷ���
	 * 
	 * @return
	 */
	public static Connection getConn() {
		// 1.ע������
		Connection conn = null;
		try {
			Class.forName(driverClass);// jdbc4.0�汾�Ժ���Բ���ע��
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver());//����ע��������
			// ��̬�����--->������˾�ִ��.java.sql.DriverManager.registerDriver(new Driver());
			// DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
			// 2.�������� ����һ:Э��+���ʵ����ݿ�,������:�û���,������:����
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return conn;
	}

	/*
	 * ������ �ͷ���Դ
	 * 
	 * @param rs
	 * 
	 * @param st
	 * 
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement st, Connection conn) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Statement st, Connection conn) {
		closeSt(st);
		closeConn(conn);
	}

	private static void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}

	private static void closeSt(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st = null;
		}
	}

	private static void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
