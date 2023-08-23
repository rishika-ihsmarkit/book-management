package com.osttra.service;

import java.util.List;
import java.util.Scanner;

import com.osttra.dao.BookDao;
import com.osttra.to.Book;

public class BookService {
	
	BookDao bookDAO = new BookDao();
	Scanner sc = new Scanner(System.in);
	
	public void listAllBooks() {
		
		List<Book> books =  bookDAO.getAllBooks();
		
		if(books.isEmpty()) {
			System.out.println("No books available...");
		}
		else {

			for (Book value : books ) {
				
				System.out.println(value.getBookid()+" : "+value.getBookname()+" : "+value.getAuthorName()+" : "+value.getDescription());
				
			}
			
		}
		
	}

	public void addBook() {
		
		System.out.println("Enter book name!!");
		String bookname = sc.nextLine();
		
		System.out.println("Enter author name!!");
		String authorName = sc.nextLine();
		
		System.out.println("Enter description!!");
		String description = sc.nextLine();
		
		System.out.println("Enter book ID!!");
		int bookid = sc.nextInt();
		
		Book book = new Book(bookname,authorName, description, bookid);
		
		bookDAO.insertBook(book);
		
		System.out.println("Book added successfully");
		
	}

	public void findBook() {
		
		System.out.println("Enter book name!!");
		String bookname = sc.nextLine();
		
		Book book = bookDAO.searchBook(bookname);
		
		if(book==null) {
			System.out.println("No such book found");
		}
		else {
				
			System.out.println(book.getBookid()+" : "+book.getBookname()+" : "+book.getAuthorName()+" : "+book.getDescription());	
			
		}
		
	}

}
