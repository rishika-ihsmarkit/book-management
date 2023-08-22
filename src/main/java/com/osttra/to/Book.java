package com.osttra.to;

public class Book {
	
	private String bookname;
	private String authorName;
	private String description;
	private int bookid;
	
	public Book(String bookname,String authorName,String description,int bookid) {
		super();
		this.bookname = bookname;
		this.authorName = authorName;
		this.description = description;
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
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

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	

}
