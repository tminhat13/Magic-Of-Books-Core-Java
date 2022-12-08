package MagicOfBooks;

import java.util.ArrayList;
import java.util.Scanner;

public class MagicOfBooks {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<User> users = new ArrayList<User>();
	static User currentUser = new User();
	
	
	public static int start() {
		while(currentUser.getUserName()==null) {
			try {
				System.out.println("---------Options---------");
				System.out.println("1. New User");
				System.out.println("2. Sign In");
				System.out.println("3. Close App");
				System.out.println("Enter select number: ");
				int input = scan.nextInt();
				scan.nextLine();
				switch(input) {
				case 1:
					createNewUser();
					break;
				case 2:
					signIn();
					break;
				case 3:
					return 0;
				default:
					System.out.println("Invalid number!");
					break;
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//System.out.println("===========" + currentUser + "==============");
		return 1;
	}
	
	public static int userMenu() {
		while(true) {
			try {
				System.out.println("---------" + currentUser + "---------");
				System.out.println("1. Sign Out");
				System.out.println("2. Add a new book");
				System.out.println("3. Show all new books");
				System.out.println("4. Add a favorite book");
				System.out.println("5. Show all favorite books");
				System.out.println("6. Add a completed book");
				System.out.println("7. Show all completed books");
				System.out.println("8. Close App");
				System.out.println("Enter select number: ");
				int input = scan.nextInt();
				scan.nextLine();
				switch(input) {
				case 1:
					currentUser = new User();
					//System.out.println(currentUser);
					return 1;
				case 2:
					
					break;
				case 8:
					return 0;
				default:
					System.out.println("Invalid number!");
					break;
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static int createNewUser() {
		String name, email, pass;
		while(true) {
			try {
				boolean usedEmail = false;
				System.out.println("--------Sign Up-------");
				System.out.println("Enter cancel anytime to go back to the prompt screen");
				System.out.println("Enter username: ");
				name = scan.nextLine();
				if(name.equals("cancel")) {
					return 1;
				}
				System.out.println("Enter email: ");
				email = scan.nextLine();
				if(email.equals("cancel")) {
					return 1;
				}
				System.out.println("Enter password: ");
				pass = scan.nextLine();
				if(pass.equals("cancel")) {
					return 1;
				}
				for(User user: users) {
					if(email.equals(user.getEmail())) {
						System.out.println("Email has been used!");
						usedEmail = true;
						break;
					}
				}
				if(!usedEmail) {
				currentUser.setUserName(name);
				currentUser.setEmail(email);
				currentUser.setPassword(pass);
				users.add(currentUser);
				return 0;
				}
			}
			catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		
	}
	
	public static int signIn() {
		String email, pass;
		while(true) {
			try {
				System.out.println("--------Sign In-------");
				System.out.println("Enter cancel anytime to go back to the prompt screen");
				System.out.println("Enter email: ");
				email = scan.nextLine();
				if(email.equals("cancel")) {
					return 1;
				}
				System.out.println("Enter password: ");
				pass = scan.nextLine();
				if(pass.equals("cancel")) {
					return 1;
				}
				for(User user: users) {
					if(email.equals(user.getUserName()) && pass.equals(user.getPassword())) {
						currentUser = user;
						System.out.println("Welcome, " + user.getUserName() + "!");
						return 0;
					}
				}
				System.out.println("Invalid username or password!");
			}
			catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		
		
		Book book1 = new Book("Cracking the Coding Interview", "Gayle Laakmann McDowell", "150 programming questions and descriptions");
		Book book2 = new Book("12 day Body Shaping Miracle", "Michael Thurmond", "#1 Diet and Fitness Makeover");
		while(true) {
			if(start()==1) {
				//System.out.println(users);
				if(userMenu()==0) {
					break;
				}
			}
			else
				break;
		}
		//System.out.println(users);
		scan.close();
	}

}
