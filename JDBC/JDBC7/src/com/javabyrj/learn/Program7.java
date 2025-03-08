package com.javabyrj.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program7 {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/rj_classes";
		String username = "root";
		String password = "rj@5588";
		
		String sql = "UPDATE employee set salary=salary+? where dept=?";
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			System.out.println("Enter the salary hike");
			int hike = scanner.nextInt();
			
			System.out.println("Enter the department");
			String dept = scanner.next();
			
			pstmt.setInt(1, hike);
			pstmt.setString(2, dept);
			
			int i = pstmt.executeUpdate();
			
			System.out.println(i);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

