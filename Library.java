import java.util.ArrayList;

import java.util.Scanner;

public class Library {
	Scanner scan = new Scanner(System.in);
	private ArrayList<Book> list;

	private static int numOfUsers;
	// Adds a book to the list

	public Library() {
		list = new ArrayList<Book>();

	}

	public void addBook(Book book) {

		list.add(book);
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

}
