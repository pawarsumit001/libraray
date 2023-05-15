package com.libraryManagement.controller;

import com.libraryManagement.dto.IssueBookDto;
import com.libraryManagement.dto.ReturnBookDto;
import com.libraryManagement.dto.StudentRequestBookDto;
import com.libraryManagement.dto.ViewStudentDto;
import com.libraryManagement.entity.Book;
import com.libraryManagement.repository.BookRepository;
import com.libraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public Book AddBook(@RequestBody Book book) {
        return this.bookService.addbook(book);
    }

    @GetMapping("/viewBook/{id}")
    public Optional<Book> viewBook(@PathVariable("id") int id) {
        return this.bookService.viewBookById(id);
    }

    @GetMapping("/viewAll")
    public List<Book> viewAllStudent() {
        return this.bookService.viewAllBook();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        this.bookService.deleteBookById(id);

    }

    @PutMapping("/update/{id}")
    public Book updateBook(@RequestBody Book book, int id) {
        return this.bookService.updateBookById(book, id);
    }

    @GetMapping("/viewBookstatus")
    public Book viewBook() {


        return this.bookService.viewAllBookOnStatus();
    }

    @GetMapping("/issue-Book")
    public IssueBookDto issueBook(){
        return  this.bookService.issueBook();
    }


   /* @GetMapping("/request-book")
    public StudentRequestBookDto requestBookDto(){
        return  this.bookService.studentRequestBook();
    }
*/



}
