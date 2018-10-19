package com.jnshu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.util.JDBCUtil;

/*使用junit执行单元测试
 * 
 */
public class TestDemo {
	@Test
	public void testQuery() {

		// 查询
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.获取连接对象
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			// 3.执行sql语句,返回ResultSet
			String sql = "SELECT*FROM s_stu";
			rs = st.executeQuery(sql);
			// 4.遍历结果集
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println(name + "  " + age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, st, conn);
		}
	}

	@Test
	public void testInsert() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			// 执行添加
			String sql = "insert into s_stu values(null,'moana',null,59,null,null,null,null,null,null,null,null)";
			//影响的行数,如果大于0表明操作成功
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(st, conn);
		}
	}
	
	@Test
	public void testDelete() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			// 执行添加
			String sql = "delete from s_stu where name='moana'";
			//影响的行数,如果大于0表明操作成功
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(st, conn);
		}
	}
	
	@Test
	public void testUpdate() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			// 执行添加
			String sql = "update s_stu set love='China' where name='wangqiang'";
			//影响的行数,如果大于0表明操作成功
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("更新成功");
			} else {
				System.out.println("更新失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(st, conn);
		}
	}
}
