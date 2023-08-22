package com.osttra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.osttra.to.Book;
import com.osttra.utils.DBUtils;

public class BookDao {
	
	Connection conn = DBUtils.getConnection();
	
	public List<Book> getAllBooks() {
		Book book = null;
		
		List<Book> books = new ArrayList<>();

		try {

			PreparedStatement statement = conn.prepareStatement("select * from book");

			ResultSet resultSet = statement.executeQuery();
			
			while( resultSet.next()){
				String bookname1 = resultSet.getString(1);
				String authorName1 = resultSet.getString(2);
				String description1 = resultSet.getString(3);
				int bookid1 = resultSet.getInt(4);
				
				book = new Book(bookname1, authorName1, description1, bookid1);
				books.add(book);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			System.out.println("inside catch of add() of BookDao...");
		}
		return books;
	}


		public void insertBook(Book book) {
			
			try {
	
				PreparedStatement statement = conn.prepareStatement("insert into book values(?, ?, ? ,?)");
	
				statement.setString(1, book.getBookname());
				statement.setString(2, book.getAuthorName());
				statement.setString(3, book.getDescription());
				statement.setInt(4, book.getBookid());
	
				statement.executeUpdate();
				
			} catch (Exception e) {
				
				System.out.println(e);
				System.out.println("inside catch of add() of BookDao...");
				
			}
			
		}


		public Book searchBook(String bookname) {
			
			Book book = null;
			
			try{
			
				PreparedStatement statement = conn.prepareStatement("select * from book where bookname=?");
				
				statement.setString(1, bookname);
	
				ResultSet resultSet = statement.executeQuery();
				
				if( resultSet.next()) {
					
					String bookname1 = resultSet.getString(1);
					String authorName1 = resultSet.getString(2);
					String description1 = resultSet.getString(3);
					int bookid1 = resultSet.getInt(4);
					
					book = new Book(bookname1, authorName1, description1, bookid1);
				}
			
			} catch (Exception e) {
				
				System.out.println("inside catch of add() of BookDao...");
				
			}
		return book;
			
		}

}
