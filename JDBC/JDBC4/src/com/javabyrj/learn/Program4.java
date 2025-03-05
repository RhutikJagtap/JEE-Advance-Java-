package com.javabyrj.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program4 {

	public static void main(String[] args) {
		
		Connection connection =null;
		 Statement statement=null;
		
		String url="jdbc:mysql://localhost:3306/rj_classes";
		String username="root";
		String password = "rj@5588";
		
		String sql = "UPDATE `employee` set `salary`=`salary`+5000 where `dept`='HR'";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 connection = DriverManager.getConnection(url,username,password);
			 
			 statement = connection.createStatement();
			 
			 int i = statement.executeUpdate(sql);
			 
			 System.out.println(i);
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			try {
				connection.close();
			}catch (SQLException e)
			{
				e.printStackTrace();
			}

		}
		
	}

}


