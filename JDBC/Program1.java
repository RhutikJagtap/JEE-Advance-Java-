//jdbc program to load the Driver class and create a connection 
package com.rj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/rj_classes";
		String username = "root";
		String password = "rj@5588";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			System.out.println(con);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch ( SQLException e) {
			e.printStackTrace();
		}

	}

}
