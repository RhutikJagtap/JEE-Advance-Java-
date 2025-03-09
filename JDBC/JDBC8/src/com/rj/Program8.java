package com.rj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program8 {
	
	public static void main(String[] args) {
		Connection connection;
		PreparedStatement pstmt;
		
		String url = "jdbc:mysql://localhost:3306/rj_classes";
		String username = "root";
		String password = "rj@5588";
		
		Scanner scanner = new Scanner(System.in);
		
		String sql="DELETE from employee where dept=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 connection = DriverManager.getConnection(url,username,password);
			 
			 pstmt = connection.prepareStatement(sql);
			 
			 System.out.println("Enter the Department");
			 pstmt.setString(1, scanner.next());
			 
			 int i = pstmt.executeUpdate();
			 
			 System.out.println(i+" employee deleted ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
