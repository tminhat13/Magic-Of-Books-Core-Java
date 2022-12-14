package MagicOfBooks;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
	private static final AtomicInteger count = new AtomicInteger(0);
	private String userName;
	private int userId;
	private String email;
	private String password;
	private ArrayList<Book> newBooks = new ArrayList<Book>();
	private ArrayList<Book> favorite = new ArrayList<Book>();
	private ArrayList<Book> completed = new ArrayList<Book>();
	
	//Constructor
	User(){
		this.userId = count.incrementAndGet();
	}
	
	User(String userName, String email, String password){
		this.userId = count.incrementAndGet();
		this.setUserName(userName);
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Book> getNewBooks() {
		return newBooks;
	}

	public void setNewBooks(ArrayList<Book> newBooks) {
		this.newBooks = newBooks;
	}
	
	public Book getBookById(int bookId) {
		try {
			for(Book book : this.newBooks) {
				if(book.getBookId()==bookId) {
					return book;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return new Book();
	}

	public void addNewBook(Book newBook) {
		this.newBooks.add(newBook);
	}

	public ArrayList<Book> getFavorite() {
		return favorite;
	}

	public void setFavorite(ArrayList<Book> favorite) {
		this.favorite = favorite;
	}
	
	public boolean addFavorite(Book book) {
		if(!this.favorite.contains(book)) {
			this.favorite.add(book);
			return false;
		}
		return true;
	}

	public ArrayList<Book> getCompleted() {
		return completed;
	}

	public void setCompleted(ArrayList<Book> completed) {
		this.completed = completed;
	}
	
	public boolean addCompleted(Book book) {
		if(!this.completed.contains(book)) {
			this.completed.add(book);
			return false;
		}
		return true;
	}
	
	public String toString() {
		return "User: " + this.userName + ", email: " + this.email;
	}
}
