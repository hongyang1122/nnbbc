package com.jnshu;

import java.sql.ResultSet;
import java.sql.Statement;
import com.util.JDBCUtil;
import java.sql.Connection;

/*JDBC介绍
 * JDBC(一种接口规范):JAVA Database Connectivity(全称)//数据库链接//用Java代码进行数据库操作
 * 为什么会出现JDBC
 * SUN公司提供的一种数据库访问规则,规范,由于数据库种类较多,并且java语言使用比较广泛,sun公司就提供了一种规范,
 * 让其他的数据库提供商去实现底层的访问规则.我们的java程序只要使用sun公司提供的jdbc驱动即可.
 *
 *使用JDBC连接数据库需要的基本四步://标准收藏代码笔记
 * 第一步,加载驱动程序;(注册驱动)
 * 第二步,连接数据库;(建立连接)
 * 第三步,访问数据库;(创建statement对象)
 * 第四步,执行查询:其中在第四步执行查询时,要用statement类的executeQuery()方法来下达select指令以查询数据库,
 * executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用.(执行sql,得到ResultSet)
 * 即语句:String sql="select * from"+tableName; ResultSet rs=s.executeQuery(sql);
 * 补充步骤:
 * 第五步,使用循环语句遍历结果集
 * 第六步,释放资源
 *
 *代码块缩进:
 * 第1步:在Eclipse中选中需要退格的代码段
 * 第2步:按住Shift,然后点击Tab键.可根据需要点击多次,实现不同的退格长度.只按Tab会有相反效果.
 * 第3步:查看代码,发现已经实现退格.
 * 
 *JDBC工具类构建
 * 1.资源释放工作的整合
 * 2.驱动防二次注册
 * DriverManager.registerDriver(new com.mysql.jdbc.Driver());
 * Driver 这个类里面有静态代码块,一上来就执行了,所以等同于我们注册了两次驱动,其实没这个必要
 * 最后形成以下代码即可
 * Class.forName("com.mysql.jdbc.Driver");
 * 
 *使用properties配置文件
 * 1.在src底下声明一个文件 xxx.properties,里面的内容如下
 *  driverClass=com.mysql.jdbc.Driver
 *	url=jdbc:mysql://localhost/student
 *	name=root
 *	password=root
 * 2.在工具类里面,使用静态代码块,读取属性
 *  static {
 *		try {
 *			Properties properties = new Properties();
 *			InputStream is = new FileInputStream("jdbc.properties");对应文件位于工程根目录
 *			//对应文件位于src目录底下
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
 *数据库的CRUD sql
 * insert
 *       SELECT*FROM s_stu;
 * delete
 *       DELETE FROM s_stu WHERE id =9;
 * query
 *       INSERT INTO s_stu()VALUES();INSERT INTO s_stu VALUES();
 * update
 *       UPDATE s_stu SET age=38 WHERE `name`="zhangsan";
 *使用单元测试,测试代码
 * 1.定义一个类,Testxxx,里面定义方法 testxxx
 * 2.添加junit的支持
 *   右键工程---add Library---Junit---Junit4
 * 3.在方法的上面加上注解,其实就是一个标记
 */
public class introduce {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {			
			conn=JDBCUtil.getConn();
			// 3.创建Statement,跟数据库打交道,一定需要这个对象
			st = conn.createStatement();
			// 4.执行查询,得到结果集
			String sql = "select*from s_stu";// 第一次犯错拼写成了t_stu,找错误找的我心态要爆炸
			rs = st.executeQuery(sql);
			// 5.遍历每一条记录
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("id:" + id + "\tname:" + name + "\tage:" + age);
			}
		} catch (Exception e) {
			// 此处抛去异常try{}catch(SQLException e){TODO Auto-generated catch block
			// e.printStackTrace();}
			e.printStackTrace();
		} finally {
			// 6.释放资源
			JDBCUtil.release(rs, st, conn);
			/*  try { 转移到JDBCUtil.java去单写 
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
