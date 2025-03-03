package com.javabyrj.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Program1 {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/rj_classes";
		String username = "root";
		String password = "rj@5588";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			System.out.println(connection);
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
