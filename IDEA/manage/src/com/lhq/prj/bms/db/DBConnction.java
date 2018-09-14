package com.lhq.prj.bms.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.DataSource;

public class DBConnction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	/**
	 * 取得一个数据库连接
	 */
	public static Connection getConnection(){
		DataSource dataSource = null;
		try 
		{
			javax.naming.Context context = new javax.naming.InitialContext();
			dataSource =(DataSource) context.lookup("java:comp/env/jdbc/zz");
			return dataSource.getConnection();
		} 
		catch (Exception e) 
		{
			System.out.println("getConnection() of DBConnection : " + e.toString());
			return null;
		}
	}
	
	/**
	 * 关闭数据库连接资源
	 */
	 public static void closeConnection(Connection conn,
			                            Statement st,
			                            ResultSet rs)
	 {
		 try
		 {
		 	if(rs!=null){
		 	   rs.close();	
		 	}
		 	if(st!=null){				
			   st.close();					
		 	}
		 	if(conn!=null){
		 	  conn.close();
		 	}
		 }catch(Exception e)
		 {
			 System.out.println("closeConnection() of DBConnection : " + e.toString());
	     }
    }
}