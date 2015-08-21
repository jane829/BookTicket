package com.tarena.tabs.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**  封装jdbc 获取连接 关闭资源等操作  */
public class DBUtil {
	private static ThreadLocal<Connection>
			connPool=new ThreadLocal<Connection>();
   
	//获取连接 
	public static Connection getConnection()throws Exception{
		//从pool中先获取Connection对象 
		Connection conn=connPool.get();
		//如果获取 不到 返回null 
		if(conn==null){
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/t_abs";
			String name="root";
			String pwd="";
			conn=DriverManager.getConnection(url,name, pwd);
		    //把新创建的connection对象存入pool
			connPool.set(conn);
		}
		return conn;
	}
	
	//关闭资源的方法
	public static void close()throws Exception{
		Connection conn = connPool.get();
		if(conn!=null){
			conn.close();
			connPool.set(null);
		}
	}
	//开启事务 
	public static void openTransaction()throws Exception{
		Connection conn=getConnection();
		if(conn!=null){
			conn.setAutoCommit(false);
		}
	}
	
	//提交事务 
	public static void commit()throws Exception{
		Connection conn=connPool.get();
		if(conn!=null){
			conn.commit();
		}
	}
}




