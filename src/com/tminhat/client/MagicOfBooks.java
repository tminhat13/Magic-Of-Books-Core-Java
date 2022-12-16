package com.tminhat.client;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.tminhat.connect.DataConnect;
import com.tminhat.model.Book;
import com.tminhat.model.User;
import com.tminhat.service.BookService;
import com.tminhat.service.UserService;

public class MagicOfBooks {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<User> users = new ArrayList<User>();
	static User currentUser = new User();
	static UserService uservice = new UserService();
	static BookService bservice = new BookService();
	static Connection con = DataConnect.getConnect();
	
	public static int start() {
		while(currentUser.getUserName()==null) {
			try {
				System.out.println("---------Welcome to Magic of Books---------");
				System.out.println("1. New User");
				System.out.println("2. Sign In");
				System.out.println("3. Close App");
				System.out.println("Enter select number: ");
				int input = scan.nextInt();
				scan.nextLine();
				switch(input) {
				case 1:
					currentUser = uservice.createNewUser();
					break;
				case 2:
					currentUser = uservice.signIn();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid number!");
					break;
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return 1;
	}
	
	public static int userMenu() {
		Book currentBook = new Book();
		while(true) {
			try {
				System.out.println("---------------------------------------------");
				System.out.println("---------User: " + currentUser.getUserName() + ", Total of Books:" +
						 "---------");
				System.out.println("---------Reading Book: " + 
						(currentBook.getBookName()!=null?currentBook.getBookName():"No book selected") + "---------");
				System.out.println("---------------------------------------------");
				System.out.println("1. Sign Out");
				System.out.println("2. Add a new book");
				System.out.println("3. Show all new books");
				System.out.println("4. Add the current selected book to favorite");
				System.out.println("5. Show all favorite books");
				System.out.println("6. Add the selected book to completed");
				System.out.println("7. Show all completed books");
				System.out.println("8. Select reading book by Id");
				System.out.println("9. Show current book details");
				System.out.println("10. Close App");
				System.out.println("Enter select number: ");
				int input = scan.nextInt();
				scan.nextLine();
				switch(input) {
				case 1:
					currentUser = new User();
					return 1;
				case 2:
					bservice.addNewBook();
					break;
				case 3:
					bservice.getNewBooks().forEach((book)->System.out.println(book));
					break;
				case 4:
					if(currentBook.getBookId()!=0) {
						if(!bservice.addFavorite(currentUser.getUserName(), currentBook.getBookId()))
							System.out.println("Add to favorite successfully!");
						else
							System.out.println("The book was already added!");
					}
					else
						System.out.println("No book selected!");
					break;
				case 5:
					bservice.getFavBooks(currentUser.getUserName()).forEach((book)->System.out.println(book));
					break;
				case 6:
					if(currentBook.getBookId()!=0) {
						if(!bservice.addCompleted(currentUser.getUserName(), currentBook.getBookId()))
							System.out.println("Add to favorite successfully!");
						else
							System.out.println("The book was already added!");
					}
					else
						System.out.println("No book selected!");
					break;
				case 7:
					bservice.getCompletedBooks(currentUser.getUserName()).forEach((book)->System.out.println(book));
					break;
				case 8:
					int bookId;
					System.out.println("Enter book Id: ");
					bookId = scan.nextInt();
					currentBook = bservice.getBookById(bookId);
					if(currentBook.getBookId()!=0) {
						System.out.println("Selected Book: " + currentBook.getBookName());
					}
					else
						System.out.println("Not found!");
					break;
				case 9:
					if(currentBook.getBookId()!=0) {
						System.out.println(currentBook);
					}
					else
						System.out.println("No book selected!");
					break;
				case 10:
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
	
	
	
	
	public static void main(String[] args) {
		while(true) {
			if(start()==1) {
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
