package com.libraryManagement.service.serviceImpl;

import com.libraryManagement.dto.GetBookStatusDto;
import com.libraryManagement.dto.IssueBookDto;
import com.libraryManagement.dto.StudentRequestBookDto;
import com.libraryManagement.dto.ViewStudentDto;
import com.libraryManagement.entity.Book;
import com.libraryManagement.entity.Student;
import com.libraryManagement.enumeration.BookStatus;
import com.libraryManagement.repository.BookRepository;
import com.libraryManagement.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

   /* @Autowired
    private GetBookStatusDTo getBookStatus;*/

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
    public Book updateBookById(Book book, int id) {
        book.setBookId(id);
        return this.bookRepository.save(book);
    }

    @Override
    public Book viewAllBookOnStatus() {
        Book reservedBooks = this.bookRepository.findByStatus(BookStatus.RESERVED);
        GetBookStatusDto getBookStatusDto = new GetBookStatusDto();
        getBookStatusDto.setStatus(reservedBooks.getStatus());

        //getBookStatusDto.setStudent(reservedBooks.getStudent());


        getBookStatusDto.setStudent(reservedBooks.getStudent());


        return this.modelMapper.map(getBookStatusDto, Book.class);
    }

    @Override
    public IssueBookDto issueBook() {
        Book issue = this.bookRepository.findByStatus(BookStatus.RESERVED);
        IssueBookDto issueBookDto = new IssueBookDto();
        issueBookDto.setBookId(issue.getBookId());
        issueBookDto.setBookName(issue.getBookname());
        issueBookDto.setIssuedDate(issue.getIssuedDate());
    /*  //  issue.getStudent().stream().map(x -> x.getName());

        issueBookDto.setName(issue.getStudent().stream().map(x -> x.getName()).toString());
        return this.modelMapper.map(issueBookDto, IssueBookDto.class);
    }*/
        List<String> studentNames = issue.getStudent()
                .stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        issueBookDto.setName(String.join(", ", studentNames));
        return this.modelMapper.map(issueBookDto, IssueBookDto.class);
    }

}
