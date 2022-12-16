package com.tminhat.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.tminhat.dao.BookDAO;
import com.tminhat.model.Book;

public class BookService {

	private Scanner scan;
	private BookDAO bdao;
	
	//constructor
	public BookService() {
		scan = new Scanner(System.in);
		bdao = new BookDAO();
	}
	public void addNewBook() {
		String name, auth, desc;
		System.out.println("Enter book name: ");
		name = scan.nextLine();
		System.out.println("Enter author name: ");
		auth = scan.nextLine();
		System.out.println("Enter description: ");
		desc = scan.nextLine();
		bdao.insertBook(name, auth, desc);
	}
	
	public ArrayList<Book> getNewBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		ResultSet result = bdao.getBooks();
		try {
			while(result.next()) {
				books.add(new Book(result.getInt(1),result.getString(2),result.getString(3),result.getString(4)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return books;
	}
	
	public ArrayList<Book> getFavBooks(String uname) {
		ArrayList<Book> books = new ArrayList<Book>();
		ResultSet result = bdao.getFavorites(uname);
		try {
			while(result.next()) {
				books.add(getBookById(result.getInt(3)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return books;
	}
	
	public ArrayList<Book> getCompletedBooks(String uname) {
		ArrayList<Book> books = new ArrayList<Book>();
		ResultSet result = bdao.getComleted(uname);
		try {
			while(result.next()) {
				books.add(getBookById(result.getInt(3)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return books;
	}
	
	public Book getBookById(int bookId) {
		Book book = new Book();
		try {
			ResultSet result = bdao.selectById(bookId);
			if(result.next()) {
				book.setBookId(result.getInt(1));
				book.setAuthorName(result.getString(3));
				book.setBookName(result.getString(2));
				book.setDescription(result.getString(4));
			}
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return book;
	}
	
	public boolean addFavorite(String uname, int bookid) {
		if(bdao.insertFavorite(uname, bookid)>0) {
			return false;
		}
		return true;
	}
	
	public boolean addCompleted(String uname, int bookid) {
		if(bdao.insertCompleted(uname, bookid)>0) {
			return false;
		}
		return true;
	}
}
