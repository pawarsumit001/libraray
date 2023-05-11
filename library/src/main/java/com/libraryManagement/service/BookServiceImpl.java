package com.libraryManagement.service;

import com.libraryManagement.entity.Book;
import com.libraryManagement.entity.Student;
import com.libraryManagement.enumeration.BookStatus;
import com.libraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;



    @Override
    public Book addbook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> viewAllBook() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> viewBookById(int id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void deleteBookById(int id) {
        this.bookRepository.deleteById(id);

    }

    @Override
    public Book updateBookById(Book book ,int id) {
        book.setBookId(id);
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> viewAllBookOnStatus() {
        List<Book> reservedBooks = this.bookRepository.findByStatus(BookStatus.RESERVED);
        if (reservedBooks != null && !reservedBooks.isEmpty()) {
        return this.bookRepository.findAll();
            }
         else {
            System.out.println("No reserved books found.");
        }
        return reservedBooks;
    }


}
