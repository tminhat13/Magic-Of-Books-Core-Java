package com.tminhat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tminhat.connect.DataConnect;

public class BookDAO {

	private Connection con;
	private PreparedStatement ps;
	
	//construction
	public BookDAO() {
		con = DataConnect.getConnect();
	}
	
	public int insertBook(String name, String auth, String desc) {
		int result = 0;
		try {
			ps = con.prepareStatement("INSERT INTO books VALUES(null, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, auth);
			ps.setString(3, desc);
			result = ps.executeUpdate();
			if(result>0) {
				System.out.println("Data inserted successfully");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public ResultSet getBooks() {
		ResultSet result = null;
		try {
			ps = con.prepareStatement("SELECT * FROM books");
			result = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public ResultSet getFavorites(String uname) {
		ResultSet result = null;
		try {
			ps = con.prepareStatement("SELECT * FROM favorites WHERE username=?");
			ps.setString(1, uname);
			result = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public ResultSet getComleted(String uname) {
		ResultSet result = null;
		try {
			ps = con.prepareStatement("SELECT * FROM completed WHERE username=?");
			ps.setString(1, uname);
			result = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public ResultSet selectById(int bookid) {
		ResultSet result = null;
		try {
			ps = con.prepareStatement("SELECT * FROM books WHERE bookid=?");
			ps.setInt(1, bookid);
			result = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int insertFavorite(String uname, int bookid) {
		int result = 0;
		try {
			ps = con.prepareStatement("INSERT INTO favorites VALUES(null, ?, ?)");
			ps.setString(1, uname);
			ps.setInt(2, bookid);
			result = ps.executeUpdate();
			if(result>0) {
				System.out.println("Data inserted successfully");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int insertCompleted(String uname, int bookid) {
		int result = 0;
		try {
			ps = con.prepareStatement("INSERT INTO completed VALUES(null, ?, ?)");
			ps.setString(1, uname);
			ps.setInt(2, bookid);
			result = ps.executeUpdate();
			if(result>0) {
				System.out.println("Data inserted successfully");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
