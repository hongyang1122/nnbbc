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
			// 创建一个属性配置对象
			Properties properties = new Properties();
			InputStream is = new FileInputStream("jdbc.properties");
			// 使用类加载器去读取src底下的资源文件
			// InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			// 导入输入流
			properties.load(is);
			// 读取属性
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
		} catch (Exception e) {// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * 获取连接对象
	 * 
	 * @return
	 */
	public static Connection getConn() {
		// 1.注册驱动
		Connection conn = null;
		try {
			Class.forName(driverClass);// jdbc4.0版本以后可以不用注册
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver());//驱动注册了两次
			// 静态代码块--->类加载了就执行.java.sql.DriverManager.registerDriver(new Driver());
			// DriverManager.getConnection("jdbc:mysql://localhost/test?user=monty&password=greatsqldb");
			// 2.建立连接 参数一:协议+访问的数据库,参数二:用户名,参数三:密码
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return conn;
	}

	/*
	 * 工具类 释放资源
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
