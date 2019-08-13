package com.lab.two.ui;

import java.util.Scanner;

import com.lab.two.entities.Book;
import com.lab.two.service.BookService;

public class Client {

	static Scanner scanner = new Scanner(System.in);

	static Client client = new Client();

	BookService service = new BookService();

	public static void main(String[] args) throws Exception {

		client.chooseAny();

	}

	public void showMenu()

	{

		System.out.println("\n1. Show All Books In Database ");

		System.out.println("2. Find Books by Author Name ");

		System.out.println("3. Find Books by Price Range");

		System.out.println("4. Find Author by Book ID");

		System.out.println("5. Exit");

		System.out.println("Enter your choice :");

	}

	public void chooseAny() throws Exception

	{

		System.out.println("----------Welcome to Central Library----------");

		int close = 0;

		while (close == 0) {

			showMenu();

			int input = scanner.nextInt();

			switch (input)

			{

			case 1: {

				// Listing all the Books

				for (Book book : service.getAllBooks()) {

					System.out.println("Book Title : " + book.getTitle() + "\nBook Author Name : " + book.getAuthor());

				}

				break;

			}

			case 2:

				// Books by Author Name

				System.out.println("Enter Name : ");

				String authorname = scanner.next();

				for (Book book : service.getAuthorBooks(authorname)) {

					System.out.println(book);

				}

				break;

			case 3:

			{

				// Books By Price Range

				System.out.println("Enter Price Range From : ");

				long priceFrom = scanner.nextLong();

				System.out.println("Enter Price Range To : ");

				long priceTo = scanner.nextLong();

				for (Book book : service.getBooksInPriceRange(priceFrom, priceTo)) {

					System.out.println("Author : " + book.getAuthor() + "\nPrice : " + book.getPrice()
							+ "\nBook Title : " + book.getTitle());

				}

				break;

			}

			case 4:

			{

				// Auhtor by Book ID

				System.out.println("Enter Book ID : ");

				int bookid = scanner.nextInt();

				Book book = service.getBookById(bookid);

				System.out.println("Author Name with ID " + bookid + " : " + book.getAuthor());

				break;

			}

			case 5:

				break;

			case 6:

				System.out.println("Do you want to exit ? press 0 to continue 1 to exit");

				close = scanner.nextInt();

				if (close == 0)

				{

					close = 0;

				} else {

					System.exit(0);

				}

			default: {

				System.out.println("Please enter valid choice!");

				chooseAny();

			}

			}

		}
	}

}
