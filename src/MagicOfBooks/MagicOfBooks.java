package MagicOfBooks;

import java.util.ArrayList;
import java.util.Scanner;

public class MagicOfBooks {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<User> users = new ArrayList<User>();
	static User currentUser = new User();
	
	
	public static int start() {
		
		while(currentUser.getUserName()==null) {
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
		//System.out.println("===========" + currentUser + "==============");
		return 1;
	}
	
	public static int workLoad() {
		while(true) {
			System.out.println("---------" + currentUser + "---------");
			System.out.println("1. Sign Out");
			System.out.println("2. Add a new book");
			System.out.println("3. Show all new books");
			System.out.println("4. Add a new favorite book");
			System.out.println("5. Show all favorite books");
			System.out.println("6. Close App");
			System.out.println("Enter select number: ");
			int input = scan.nextInt();
			scan.nextLine();
			switch(input) {
			case 1:
				currentUser = new User();
				users.add(currentUser);
				System.out.println(currentUser);
				return 1;
			case 2:
				
				break;
			case 6:
				return 0;
			default:
				System.out.println("Invalid number!");
				break;
			}
		}
	}
	
	public static int createNewUser() {
		String user, email, pass;
		while(true) {
			try {
				System.out.println("--------Sign Up-------");
				System.out.println("Enter cancel anytime to go back to the prompt screen");
				System.out.println("Enter username: ");
				user = scan.nextLine();
				if(user.equals("cancel")) {
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
				currentUser.setUserName(user);
				currentUser.setEmail(email);
				currentUser.setPassword(pass);
				return 0;
			}
			catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		
	}
	
	public static int signIn() {
		String name, pass;
		while(true) {
			try {
				System.out.println("--------Sign In-------");
				System.out.println("Enter cancel anytime to go back to the prompt screen");
				System.out.println("Enter username: ");
				name = scan.nextLine();
				if(name.equals("cancel")) {
					return 1;
				}
				System.out.println("Enter password: ");
				pass = scan.nextLine();
				if(pass.equals("cancel")) {
					return 1;
				}
				for(User user: users) {
					if(name.equals(user.getUserName()) && pass.equals(user.getPassword())) {
						currentUser = user;
						System.out.println(currentUser);
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
		
		users.add(currentUser);
		while(true) {
			if(start()==1) {
				if(workLoad()==0) {
					break;
				}
			}
		}
		scan.close();
	}

}
