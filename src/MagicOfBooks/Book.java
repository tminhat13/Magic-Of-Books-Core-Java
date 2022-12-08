package MagicOfBooks;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private String bookName;
	private int bookId;
	private String authorName;
	private String description;
	
	//constructions
	public Book(){}
	
	public Book(String bookName, String authorName, String description) {
		super();
		this.bookName = bookName;
		this.bookId = count.incrementAndGet();
		this.authorName = authorName;
		this.description = description;
	}
	
	public Book(int bookId, String bookName, String authorName, String description) {
		super();
		this.bookName = bookName;
		this.bookId = bookId;
		this.authorName = authorName;
		this.description = description;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookId() {
		return bookId;
	}

//	public void setBookId(int bookId) {
//		this.bookId = bookId;
//	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "Book ID: " + this.bookId +", Book Name: " + this.bookName + ", Author: " + this.authorName + ", Description: " + this.description;
	}
	
}
