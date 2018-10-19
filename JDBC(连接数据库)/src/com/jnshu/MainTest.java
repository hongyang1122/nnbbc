package com.jnshu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.util.JDBCUtil;

public class MainTest {
	public static void main(String[] args) {
		//��ѯ
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;		
		try {			
			//1.��ȡ���Ӷ���
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			//3.ִ��sql���,����ResultSet
			String sql = "SELECT*FROM s_stu";
			rs=st.executeQuery(sql);
			//4.���������
			while(rs.next()){
				String name=rs.getString("name");
				int age=rs.getInt("age");
				System.out.println(name+"  "+age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(rs, st, conn);
		}

	}
}
