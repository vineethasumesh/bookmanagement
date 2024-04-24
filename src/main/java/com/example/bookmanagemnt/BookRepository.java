package com.example.bookmanagemnt;

public interface BookRepository {
	 Book save(Book book);
	 Book findByIsbn(String isbn);
	 Book update(Book book);
	}