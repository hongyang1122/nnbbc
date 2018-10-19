package com.jnshu;

import java.sql.ResultSet;
import java.sql.Statement;
import com.util.JDBCUtil;
import java.sql.Connection;

/*JDBC����
 * JDBC(һ�ֽӿڹ淶):JAVA Database Connectivity(ȫ��)//���ݿ�����//��Java����������ݿ����
 * Ϊʲô�����JDBC
 * SUN��˾�ṩ��һ�����ݿ���ʹ���,�淶,�������ݿ�����϶�,����java����ʹ�ñȽϹ㷺,sun��˾���ṩ��һ�ֹ淶,
 * �����������ݿ��ṩ��ȥʵ�ֵײ�ķ��ʹ���.���ǵ�java����ֻҪʹ��sun��˾�ṩ��jdbc��������.
 *
 *ʹ��JDBC�������ݿ���Ҫ�Ļ����Ĳ�://��׼�ղش���ʼ�
 * ��һ��,������������;(ע������)
 * �ڶ���,�������ݿ�;(��������)
 * ������,�������ݿ�;(����statement����)
 * ���Ĳ�,ִ�в�ѯ:�����ڵ��Ĳ�ִ�в�ѯʱ,Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ�,
 * executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ��.(ִ��sql,�õ�ResultSet)
 * �����:String sql="select * from"+tableName; ResultSet rs=s.executeQuery(sql);
 * ���䲽��:
 * ���岽,ʹ��ѭ�������������
 * ������,�ͷ���Դ
 *
 *���������:
 * ��1��:��Eclipse��ѡ����Ҫ�˸�Ĵ����
 * ��2��:��סShift,Ȼ����Tab��.�ɸ�����Ҫ������,ʵ�ֲ�ͬ���˸񳤶�.ֻ��Tab�����෴Ч��.
 * ��3��:�鿴����,�����Ѿ�ʵ���˸�.
 * 
 *JDBC�����๹��
 * 1.��Դ�ͷŹ���������
 * 2.����������ע��
 * DriverManager.registerDriver(new com.mysql.jdbc.Driver());
 * Driver ����������о�̬�����,һ������ִ����,���Ե�ͬ������ע������������,��ʵû�����Ҫ
 * ����γ����´��뼴��
 * Class.forName("com.mysql.jdbc.Driver");
 * 
 *ʹ��properties�����ļ�
 * 1.��src��������һ���ļ� xxx.properties,�������������
 *  driverClass=com.mysql.jdbc.Driver
 *	url=jdbc:mysql://localhost/student
 *	name=root
 *	password=root
 * 2.�ڹ���������,ʹ�þ�̬�����,��ȡ����
 *  static {
 *		try {
 *			Properties properties = new Properties();
 *			InputStream is = new FileInputStream("jdbc.properties");��Ӧ�ļ�λ�ڹ��̸�Ŀ¼
 *			//��Ӧ�ļ�λ��srcĿ¼����
 *			//InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
 *			properties.load(is);
 *			driverClass = properties.getProperty("driverClass");
 *			url = properties.getProperty("url");
 *			name = properties.getProperty("name");
 *			password = properties.getProperty("password");
 *		} catch (Exception e) {
 *			e.printStackTrace();
 *		}
 *	}
 *
 *���ݿ��CRUD sql
 * insert
 *       SELECT*FROM s_stu;
 * delete
 *       DELETE FROM s_stu WHERE id =9;
 * query
 *       INSERT INTO s_stu()VALUES();INSERT INTO s_stu VALUES();
 * update
 *       UPDATE s_stu SET age=38 WHERE `name`="zhangsan";
 *ʹ�õ�Ԫ����,���Դ���
 * 1.����һ����,Testxxx,���涨�巽�� testxxx
 * 2.���junit��֧��
 *   �Ҽ�����---add Library---Junit---Junit4
 * 3.�ڷ������������ע��,��ʵ����һ�����
 */
public class introduce {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {			
			conn=JDBCUtil.getConn();
			// 3.����Statement,�����ݿ�򽻵�,һ����Ҫ�������
			st = conn.createStatement();
			// 4.ִ�в�ѯ,�õ������
			String sql = "select*from s_stu";// ��һ�η���ƴд����t_stu,�Ҵ����ҵ�����̬Ҫ��ը
			rs = st.executeQuery(sql);
			// 5.����ÿһ����¼
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("id:" + id + "\tname:" + name + "\tage:" + age);
			}
		} catch (Exception e) {
			// �˴���ȥ�쳣try{}catch(SQLException e){TODO Auto-generated catch block
			// e.printStackTrace();}
			e.printStackTrace();
		} finally {
			// 6.�ͷ���Դ
			JDBCUtil.release(rs, st, conn);
			/*  try { ת�Ƶ�JDBCUtil.javaȥ��д 
			 *		 * if (rs != null) {
			 *			rs.close();
			 *		}
			 *	} catch (SQLException e) {
			 *		e.printStackTrace();
			 *	} finally {
			 *		rs = null;
			 *	}
			 */
			// st.close();
			// conn.close();
		}
	}
}
