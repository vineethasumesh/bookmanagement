package com.example.bookmanagemnt;

public interface BookService {
	 Book addBook(Book book);
	 Book getBookByIsbn(String isbn);
	 Book updateBook(String isbn, Book book);
	}
