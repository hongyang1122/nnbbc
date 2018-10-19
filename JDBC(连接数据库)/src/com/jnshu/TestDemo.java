package com.jnshu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.util.JDBCUtil;

/*ʹ��junitִ�е�Ԫ����
 * 
 */
public class TestDemo {
	@Test
	public void testQuery() {

		// ��ѯ
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.��ȡ���Ӷ���
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			// 3.ִ��sql���,����ResultSet
			String sql = "SELECT*FROM s_stu";
			rs = st.executeQuery(sql);
			// 4.���������
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
			// ִ�����
			String sql = "insert into s_stu values(null,'moana',null,59,null,null,null,null,null,null,null,null)";
			//Ӱ�������,�������0���������ɹ�
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("���ʧ��");
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
			// ִ�����
			String sql = "delete from s_stu where name='moana'";
			//Ӱ�������,�������0���������ɹ�
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ��");
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
			// ִ�����
			String sql = "update s_stu set love='China' where name='wangqiang'";
			//Ӱ�������,�������0���������ɹ�
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("���³ɹ�");
			} else {
				System.out.println("����ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(st, conn);
		}
	}
}
