package com.tminhat.connect;

import java.sql.*;

public class DataConnect {
	private static Connection con;
	private DataConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/magic_of_books", "root", "mypass");
			System.out.println("Connection established");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static Connection getConnect() {
		DataConnect dataConnect = new DataConnect();
		return con;
	}
}
