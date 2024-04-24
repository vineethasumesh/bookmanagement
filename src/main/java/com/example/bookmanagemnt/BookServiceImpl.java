package com.example.bookmanagemnt;

public class BookServiceImpl implements BookService {
private final BookRepository bookRepository;
public BookServiceImpl(BookRepository bookRepository) {
 this.bookRepository = bookRepository;
 }
 @Override
 public Book addBook(Book book) {
 return bookRepository.save(book);
 }
 @Override
 public Book getBookByIsbn(String isbn) {
 return bookRepository.findByIsbn(isbn);
 }
 @Override
 public Book updateBook(String isbn, Book book) {
 Book existingBook = bookRepository.findByIsbn(isbn);
 if (existingBook == null) {
 return null; // Book not found
 }
 return bookRepository.update(book);
 }
}