package com.library.management.LibraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.LibraryManagement.entity.Book;
import com.library.management.LibraryManagement.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/library/book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);
            return ResponseEntity.ok("Book added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding book: " + e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllBooks() {
        try {
            return ResponseEntity.ok(bookService.findAllBooks());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching books: " + e.getMessage());
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        try {
            Book book = bookService.findBookById(id);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found: " + e.getMessage());
        }
    }

    @GetMapping("bookname/{bookName}")
    public ResponseEntity<?> getBookByBookName(@PathVariable String bookName) {
        try {
            return ResponseEntity.ok(bookService.findBookByBookName(bookName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching book by name: " + e.getMessage());
        }
    }

    @GetMapping("authorname/{authorName}")
    public ResponseEntity<?> getBookByAuthorName(@PathVariable String authorName) {
        try {
            return ResponseEntity.ok(bookService.findBookByAuthorName(authorName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching book by author name: " + e.getMessage());
        }
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            Book updatedBook = bookService.updateBookById(id, book);
            return ResponseEntity.ok(updatedBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating book: " + e.getMessage());
        }
    }

    @PutMapping("bookname/{bookName}")
    public ResponseEntity<?> updateBookByBookName(@PathVariable String bookName, @RequestBody Book book) {
        try {
            Book updatedBook = bookService.updateBookByBookName(bookName, book);
            return ResponseEntity.ok(updatedBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating book by name: " + e.getMessage());
        }
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {
        try {
            bookService.deleteBookById(id);
            return ResponseEntity.ok("Book deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting book: " + e.getMessage());
        }
    }

    @DeleteMapping("bookname/{bookName}")
    public ResponseEntity<?> deleteBookByBookName(@PathVariable String bookName) {
        try {
            bookService.deleteBookByBookName(bookName);
            return ResponseEntity.ok("Book deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting book by name: " + e.getMessage());
        }
    }
}
