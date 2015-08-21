package com.tarena.tabs.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**  ��װjdbc ��ȡ���� �ر���Դ�Ȳ���  */
public class DBUtil {
	private static ThreadLocal<Connection>
			connPool=new ThreadLocal<Connection>();
   
	//��ȡ���� 
	public static Connection getConnection()throws Exception{
		//��pool���Ȼ�ȡConnection���� 
		Connection conn=connPool.get();
		//�����ȡ ���� ����null 
		if(conn==null){
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/t_abs";
			String name="root";
			String pwd="";
			conn=DriverManager.getConnection(url,name, pwd);
		    //���´�����connection�������pool
			connPool.set(conn);
		}
		return conn;
	}
	
	//�ر���Դ�ķ���
	public static void close()throws Exception{
		Connection conn = connPool.get();
		if(conn!=null){
			conn.close();
			connPool.set(null);
		}
	}
	//�������� 
	public static void openTransaction()throws Exception{
		Connection conn=getConnection();
		if(conn!=null){
			conn.setAutoCommit(false);
		}
	}
	
	//�ύ���� 
	public static void commit()throws Exception{
		Connection conn=connPool.get();
		if(conn!=null){
			conn.commit();
		}
	}
}




