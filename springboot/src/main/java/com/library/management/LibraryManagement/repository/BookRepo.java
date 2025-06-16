package com.library.management.LibraryManagement.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.management.LibraryManagement.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query("SELECT * FROM book WHERE author_name = ?1")
    List<Book> findByAuthorName(String authorName);

    @Query("SELECT * FROM book WHERE book_name = ?1")
    Book findByBookName(String bookName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.bookName = ?1")
    int deleteByBookName(String bookName);

}
