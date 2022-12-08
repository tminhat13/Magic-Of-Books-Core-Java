package MagicOfBooks;

import java.util.ArrayList;

public class User {
	private String userName;
	private String userId;
	private String email;
	private String password;
	private ArrayList<Book> newBooks = new ArrayList<Book>();
	private ArrayList<Book> favorite = new ArrayList<Book>();
	private ArrayList<Book> completed = new ArrayList<Book>();
	
	//Constructor
	User(){}
	
	User(String userName, String userId, String email, String password){
		this.setUserName(userName);
		this.setUserId(userId);
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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
	
	public Book getNewBookById(int bookId) {
		try {
			for(Book book : newBooks) {
				if(book.getBookId()==bookId) {
					return book;
				}
			}
			System.out.println("Not found!");
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
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

	public ArrayList<Book> getCompleted() {
		return completed;
	}

	public void setCompleted(ArrayList<Book> completed) {
		this.completed = completed;
	}
	
	
}
