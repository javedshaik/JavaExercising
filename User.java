import java.util.ArrayList;
import java.util.Scanner;

public class User {

	Scanner scan = new Scanner(System.in);
	ArrayList<Book> list;
	private String user;

	public User() {
		list = new ArrayList<Book>();
	}

	public User(String libUser) {
		this.user = libUser;
	}

	public String getUser() {
		return user;
	}
	
	public String getUserName(User u) {
		return u.user;
	}

	public void setUser(String libUser) {
		this.user = libUser;
	}
	
	

	public void borrowBook(String title, String author) {
		int found = 0;
		for (Book book : list) {
			if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
				if (found == 0) {
					found = 1;
				}
				if (!book.isBorrowed()) {
					book.borrowed();
					found = 2;
					break;
				}
				;
			}
		}
		if (found == 0) {
			System.out.println("Sorry, this book is not in our catalog.");
		} else if (found == 1) {
			System.out.println("Sorry, this book is already borrowed.");
		} else if (found == 2) {
			System.out.println("You successfully borrowed " + title);
		}
	}

	public void returnBook(String title) {
		boolean found = false;
		for (Book book : list) {
			if (book.getTitle().equals(title) && book.isBorrowed()) {
				book.returned();
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("You successfully returned " + title);
		}
	}

	public void printAvailableBooks() {
		boolean bookPresent = false;
		for (Book book : list) {
			if (!book.isBorrowed()) {
				System.out.println(book.getTitle());
				bookPresent = true;
			}
		}
		if (!bookPresent) {
			System.out.println("No book in catalog");
		}
	}

}
