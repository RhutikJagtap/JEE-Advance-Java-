package com.javabyrj.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program6 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/rj_classes";
		String username = "root";
		String password = "rj@5588";
		
		String sql="SELECT * from `employee` where dept=?";
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			System.out.println("Enter the department Name");
			String dept = scanner.nextLine();
			pstmt.setString(1,dept);
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println("------------------------------------------");
			while (rs.next()) {
				
				System.out.printf("%-2d| %-7s| %-18s| %-3s| %-7d|\n" ,rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("dept"),rs.getInt("salary"));
			}
			System.out.println("------------------------------------------");

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}