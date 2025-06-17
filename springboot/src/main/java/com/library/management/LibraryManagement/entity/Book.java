package com.library.management.LibraryManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String bookName;

    private String authorName;
    
    private int quantity;

    public Book() {
    }

    public Book(Long id, String bookName, String authorName, int quantity) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.quantity = quantity;
    }
}
