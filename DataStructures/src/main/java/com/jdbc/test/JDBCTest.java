package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		System.out.println("All set to connect to AccountManagement MySQL DB");

		String url = "jdbc:mysql://localhost/AccountManagement";
		String userId = "ashesh";
		String password = "cool";
		Connection con;
		String sql;
		Statement stmt;
		ResultSet rs;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, userId, password);
			sql = "SELECT * FROM STUDENT WHERE first_name = 'Rishab'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println();
				System.out.println(rs.getString("first_name"));
				System.out.println(rs.getString("middle_name"));
				System.out.println(rs.getString("last_name"));
				System.out.println(rs.getString("father_first_name"));
				System.out.println(rs.getString("father_middle_name"));
				System.out.println(rs.getString("father_last_name"));
				System.out.println(rs.getString("mother_first_name"));
				System.out.println(rs.getString("mother_middle_name"));
				System.out.println(rs.getString("mother_last_name"));
				System.out.println(rs.getString("DOB"));
				System.out.println(rs.getString("start_date"));
				System.out.println(rs.getString("end_date"));
				System.out.println(rs.getString("Address"));
				System.out.println(rs.getString("Phone_Father"));
				System.out.println(rs.getString("Phone_Mother"));
				System.out.println(rs.getString("Phone_Home"));
				System.out.println(rs.getString("mode_of_payment"));
				System.out.println(rs.getDouble("fee"));
				System.out.println(rs.getString("isActive"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
