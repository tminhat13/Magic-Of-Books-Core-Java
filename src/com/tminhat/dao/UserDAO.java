package com.tminhat.dao;

import java.sql.*;

import com.tminhat.connect.DataConnect;
import com.tminhat.model.User;

public class UserDAO {
	private Connection con;
	private PreparedStatement ps;
	
	//construction
	public UserDAO() {
		con = DataConnect.getConnect();
	}
	
	public int insertUser(User user) {
		int result = 0;
		try {
			ps = con.prepareStatement("INSERT INTO users VALUES(?, ?, ?)");
			ps.setString(1, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(2, user.getEmail());
			result = ps.executeUpdate();
			if(result>0) {
				System.out.println("Data inserted successfully");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public User findUser(String name, String pass) {
		User user = new User();
		try {
			ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				user.setUserName(result.getString(1));
				user.setPassword(result.getString(2));
				user.setEmail(result.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
}
