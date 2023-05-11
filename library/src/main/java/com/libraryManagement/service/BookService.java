package com.libraryManagement.service;

import com.libraryManagement.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    public Book addbook(Book book);

    List<Book> viewAllBook();

    public Optional<Book> viewBookById(int id);

    public void deleteBookById(int id);

    public Book updateBookById(Book book,int id);

    List<Book> viewAllBookOnStatus();
}
