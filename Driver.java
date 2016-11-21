import java.util.Scanner;

public class Driver {

	public static int runLoop() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("1. To create a user account");
		System.out.println("2. Do you want to add a book?");
		System.out.println("3. Do you want to delete a book?");
		System.out.println("4. Do you want to borrow a book?");
		System.out.println("5. Print the books available in the library");
		System.out.println("6. Do you wan to return a book?");
		System.out.println("7. Search for a book?");
		System.out.println("8. Exit the program");
		int input = scan.nextInt();
		return input;

	}

	public static void main(String[] args) {

		boolean stop = true;
		Scanner scan = new Scanner(System.in);
		Library lib = new Library();

		while (stop) {
			System.out.println(
					"Welcome to the library. You currently have: " + lib.getNumUsers() + " users in your library.");
			int input = runLoop();
			switch (input) {
			case 1:
				System.out.println("Please enter a username to create an account: ");
				String libUser = scan.nextLine();

			case 2:
				System.out.println("Enter the title of the book you wish to add: ");
				String bookTitle = scan.nextLine();
				System.out.println("Enter the author of the book: ");
				String bookAuthor = scan.nextLine();
				System.out.println("Enter the description of the book: ");
				String bookDescription = scan.nextLine();
				System.out.println();
				Book a = new Book(bookTitle, bookAuthor, bookDescription);
				System.out.println("Book successfully added");
				lib.addBook(a);
				break;
			case 3:
				System.out.println("Enter the title of the book you want to remove: ");
				String bookTitleRemove = scan.nextLine();
				System.out.println("Enter the author of the book you want to remove: ");
				String bookAuthorRemove = scan.nextLine();
				lib.deleteBook(bookTitleRemove, bookAuthorRemove);
				System.out.println("Sucessfully removed the book!");
				break;
			case 5:
				System.out.println("These are all the books available in the library: ");
				lib.printAvailableBooks();
				break;
			case 7:
				System.out.println("Enter the book title you want to search: ");
				String title = scan.nextLine();
				System.out.println("Enter the auhtor of book");
				String author = scan.nextLine();
				lib.searchBook(title, author);
			case 8:
				stop = false;
				break;
			}

		}
		System.out.println("Thank you for using the system.");
	}

}
