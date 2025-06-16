package com.library.management.LibraryManagement.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.LibraryManagement.entity.Book;
import com.library.management.LibraryManagement.repository.BookRepo;
import com.library.management.LibraryManagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Override
    public Book addBook(Book book) {
        if (book == null) {
            throw new RuntimeException("Book cannot be null");
        } else if (book.getBookName() == null || book.getBookName().isEmpty()) {
            throw new RuntimeException("Book name cannot be null or empty");
        } else if (book.getAuthorName() == null || book.getAuthorName().isEmpty()) {
            throw new RuntimeException("Author name cannot be null or empty");
        } else if (book.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than zero");
        } else if (bookRepo.findByBookName(book.getBookName()).size() > 0) {
            throw new RuntimeException("Book with this name already exists");
        } else {
            return bookRepo.save(book);
        }
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book updatedbook = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (updatedbook != null) {
            updatedbook.setBookName(book.getBookName());
            updatedbook.setAuthorName(book.getAuthorName());
            updatedbook.setQuantity(book.getQuantity());
            return bookRepo.save(updatedbook);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    @Override
    public Boolean deleteBookById(Long id) {
        if (!bookRepo.existsById(id)) {
            throw new RuntimeException("Book not found");
        } else {
            bookRepo.deleteById(id);
            return true;
        }
    }

    @Override
    public Boolean deleteBookByBookName(String bookName) {
        if (bookName == null || bookName.isEmpty()) {
            throw new RuntimeException("Book name cannot be null or empty");
        } else if (!bookRepo.findByBookName(bookName).isEmpty()) {
            bookRepo.deleteByBookName(bookName);
            return true;
        } else {
            throw new RuntimeException("Book not found");
        }

    }

    @Override
    public Book findBookById(Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> findBookByAuthorName(String authorName) {
        if (authorName == null || authorName.isEmpty()) {
            throw new RuntimeException("Author name cannot be null or empty");
        } else {
            return bookRepo.findByAuthorName(authorName);
        }
    }

    @Override
    public List<Book> findBookByBookName(String bookName) {
        if (bookName == null || bookName.isEmpty()) {
            throw new RuntimeException("Book name cannot be null or empty");
        } else {
            return bookRepo.findByBookName(bookName);
        }
    }

    @Override
    public List<Book> findBookByAuthorAndBookName(String authorName, String bookName) {
        if (authorName == null || authorName.isEmpty() || bookName == null || bookName.isEmpty()) {
            throw new RuntimeException("Author name and Book name cannot be null or empty");
        } else {
            return bookRepo.findByAuthorAndBookName(authorName, bookName);
        }
    }
}
