
public class Book {

	private String title;
	private String author;
	private String description;
	boolean borrowed;

	public Book(String bookTitle, String bookAuthor, String bookDescription) {
		this.title = bookTitle;
		this.author = bookAuthor;
		this.description = bookDescription;

	}

	public Book() {
		this.title = "None";
		this.author = "None";
		this.description = "None";
	}

	public Book(Book other) {
		this.title = other.title;
		this.author = other.author;
		this.description = other.description;

	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public void setTitle(String bookTitle) {
		this.title = bookTitle;
	}

	public void setAuthor(String bookAuthor) {
		this.author = bookAuthor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String bookDescription) {
		this.description = bookDescription;
	}

	@Override
	public String toString() {
		String s = "";
		s += " Title: " + this.title;
		s += " Author: " + this.author;
		s += " Description: " + this.description;
		return s;
	}

	// Labels the book as checked-out
	public void borrowed() {
		borrowed = true;
	}

	// Labels the book as not checked out
	public void returned() {
		borrowed = false;
	}

	// Return true if the book is borrowed, if not returns false
	public boolean isBorrowed() {
		if (borrowed) {
			return true;
		} else
			return false;
	}
}
