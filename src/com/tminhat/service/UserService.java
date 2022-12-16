package com.tminhat.service;

import java.util.*;

import com.tminhat.dao.UserDAO;
import com.tminhat.model.User;

public class UserService {
	private Scanner scan;
	private UserDAO udao;
	
	//constructor
	public UserService() {
		scan = new Scanner(System.in);
		udao = new UserDAO();
	}
	
	public User createNewUser() {
		String name, email, pass;
		User newUser = new User();
		while(true) {
			try {
				System.out.println("--------Sign Up-------");
				System.out.println("Enter cancel anytime to go back to the prompt screen");
				System.out.println("Enter Username: ");
				name = scan.nextLine();
				if(name.equals("cancel")) {
					return newUser;
				}
				System.out.println("Enter Email: ");
				email = scan.nextLine();
				if(email.equals("cancel")) {
					return newUser;
				}
				System.out.println("Enter Password: ");
				pass = scan.nextLine();
				if(pass.equals("cancel")) {
					return newUser;
				}
				newUser.setUserName(name);
				newUser.setEmail(email);
				newUser.setPassword(pass);
				if(udao.insertUser(newUser)==0) {
					System.out.println("Username is already exited!");
					return new User();
				}
				else {
					return newUser;
				}
			}
			catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	public User signIn() {
		String name, pass;
		User user = new User();
		while(true) {
			try {
				System.out.println("--------Sign In-------");
				System.out.println("Enter cancel anytime to go back to the prompt screen");
				System.out.print("Username: ");
				name = scan.nextLine();
				if(name.equals("cancel")) {
					break;
				}
				System.out.print("Password: ");
				pass = scan.nextLine();
				if(pass.equals("cancel")) {
					break;
				}
				user.setUserName(name);
				user.setPassword(pass);
				user = udao.findUser(name, pass);
				if(user.getUserName()!=null) {
					System.out.println("Hello "+user.getUserName()+"!");
					break;
				}
				System.out.println("Invalid username or password!");
			}
			catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		return user;
	}
}
