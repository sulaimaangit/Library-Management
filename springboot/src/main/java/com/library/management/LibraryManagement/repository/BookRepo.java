package com.library.management.LibraryManagement.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.management.LibraryManagement.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
   
    @Query("SELECT * FROM book WHERE author_name = ?1")
    List<Book> findByAuthorName(String authorName);
    
    @Query("SELECT * FROM book WHERE book_name = ?1")
    List<Book> findByBookName(String bookName); 

    @Query("SELECT * FROM book WHERE author_name = ?1 AND book_name = ?2")
    List<Book> findByAuthorAndBookName(String authorName, String bookName);

    @Query("SELECT * FROM book WHERE author_name = ?1 OR book_name = ?2")
    List<Book> findByAuthorOrBookName(String authorName, String bookName);

    @Query("DELETE FROM book WHERE book_name = ?1")
    Boolean deleteByBookName(String bookName);

}
