//jdbc program fetch the employee details from databases
package com.rj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	public static void main(String[] args) {
		Connection connection =null;
		Statement statement =null;
		ResultSet rs=null;
		
		String url = "jdbc:mysql://localhost:3306/rj_classes";
		String username = "root";
		String password = "rj@5588";
		
		String sql="SELECT *from `employee`";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 connection = DriverManager.getConnection(url,username,password);
			
			 statement = connection.createStatement();
			
			 rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
			System.out.println(rs.getInt("id")+" "+
				rs.getString("name")+" "+
				rs.getString("email")+" "+
				rs.getString("dept")+" "+
				rs.getInt("salary"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
 		   e.printStackTrace();
		}finally {
			
			closeConnection(connection, statement, rs);
		
			
		}
		
	}

	private static void closeConnection(Connection connection, Statement statement, ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
