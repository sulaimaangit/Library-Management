package com.library.management.LibraryManagement.service;

import java.util.List;

import com.library.management.LibraryManagement.entity.Book;

public interface BookService {
    
    // Method to add a new book
    Book addBook(Book book);

    // Method to update an existing book
    Book updateBook(Long id, Book book);

    // Method to delete a book by ID
    Boolean deleteBookById(Long id);

    // Method to delete a book by Book object
    Boolean deleteBookByBookName(String bookName);

    // Method to get details of a book by ID
    Book findBookById(Long id);

    // Method to get all books
    List<Book> findAllBooks();

    // Method to find books by author name
    List<Book> findBookByAuthorName(String authorName);

    // Method to find books by book name
    List<Book> findBookByBookName(String bookName);   

    // Method to find books by author name and book name
    List<Book> findBookByAuthorAndBookName(String authorName, String bookName);


}
