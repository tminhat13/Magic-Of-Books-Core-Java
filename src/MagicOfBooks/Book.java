package MagicOfBooks;

public class Book {
	

	private String bookName;
	private int bookId;
	private String authorName;
	private String description;
	
	//constructions
	public Book(){}
	
	public Book(String bookName, int bookId, String authorName, String description) {
		super();
		this.setBookName(bookName);
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

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

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
	
	
}
