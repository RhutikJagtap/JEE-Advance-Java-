package com.javabyrj.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program5 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/rj_classes";
		String username = "root";
		String password = "rj@5588";
		
		String sql = "DELETE from employee where dept='HR' ";
		
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			Statement statement = connection.createStatement();
			
			int i = statement.executeUpdate(sql);
			
			System.out.println(i);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
