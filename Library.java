import java.util.ArrayList;

import java.util.Scanner;

public class Library {
	Scanner scan = new Scanner(System.in);
	private ArrayList<Book> list;
	private ArrayList<User> users;
	private static int numOfUsers;
	// Adds a book to the list

	public Library() {
		list = new ArrayList<Book>();
		users = new ArrayList<User>();
	}

	public void addBook(Book book) {

		list.add(book);

	}

	public void addUser(User u) {
		users.add(u);
		numOfUsers++;
	}

	// Deletes a book forever from the list
	public void deleteBook(String title, String author) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title) && list.get(i).getAuthor().equals(author)) {
				list.remove(i);
			}
		}

	}

	public int getNumUsers() {
		return numOfUsers;
	}

	public void printAvailableBooks() {
		boolean bookPresent = false;
		for (Book book : list) {
			if (!book.isBorrowed()) {
				System.out.println("Title: " + book.getTitle() + " " + "Author: " + book.getAuthor());
				bookPresent = true;
			}
		}
		if (!bookPresent) {
			System.out.println("No book in catalog");
		}
	}

	public void searchBook(String title, String author) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title) && list.get(i).getAuthor().equals(author)) {
				Book a = new Book(list.get(i));
				System.out.println(a.toString());
			} else
				System.out.println("Book not found!");
		}
	}

	public void borrowBook(String username, String title, String author) {
		int found = 0;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUser().equals(username)) {
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
			else if(!users.get(i).getUser().equals(username)){
				System.out.println("Wrong user");
			}
			
		}
		

	}

	public void returnBook(String username, String title) {

		boolean found = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUser().equals(username)) {
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
			else 
				System.out.println("Wrong user");
		}
	}

}
