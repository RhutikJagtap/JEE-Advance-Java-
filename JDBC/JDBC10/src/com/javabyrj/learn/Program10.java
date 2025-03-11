package com.javabyrj.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program10{
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/rj_classes";
		String username = "root";
		String password = "rj@5588";
		
		String sql = "INSERT into employee(id,name,email,dept,salary) values(?,?,?,?,?)";
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			String choice=null;
			
			do {
				System.out.println("Enter the Id");
				int id = scanner.nextInt();
				
				System.out.println("Enter the name");
				String name = scanner.next();
				
				System.out.println("Enter the email");
				String email = scanner.next();
				
				System.out.println("Enter the department");
				String dept = scanner.next();
				
				System.out.println("Enter the salary");
				int salary = scanner.nextInt();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, email);
				pstmt.setString(4, dept);
				pstmt.setInt(5, salary);
				
				int i = pstmt.executeUpdate();
				System.out.println(i);
				
				System.out.println("Do you want to insert more employees(yes/no)");
			    choice = scanner.next();
				
			} while (choice.equalsIgnoreCase("yes"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
