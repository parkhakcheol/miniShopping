package com.park.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
	
	public Connection driverDb() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mvcmini?useUnicode=true&characterEncoding=utf-8";
		String dbUser = "root";
		String dbPass = "java0000";
		
		Class.forName(driver);
		//DB����
		connection = DriverManager.getConnection(url, dbUser, dbPass);
		
		return connection;
	}

	
}
