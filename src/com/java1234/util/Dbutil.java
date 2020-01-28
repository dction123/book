package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
	private  String dbUrl="jdbc:mysql://127.0.0.1:3306/db_book?useSSL=false&serverTimezone=UTC";
	private  String dbUserName="root";
	private  String dbPassword="123456";
	private  String jdbcName="com.mysql.cj.jdbc.Driver";
	public Connection getConnection() throws Exception{
		Class.forName(jdbcName);
		Connection conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return conn;
		
	}
	public void closeConnection(Connection conn) throws Exception{
		if(conn!=null) {
			conn.close();
			
		}
		
	}
	public static void main(String[] args) throws Exception {
		Dbutil db=new Dbutil();
		System.out.println(db.getConnection());
		
	}
}
