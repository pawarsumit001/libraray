package com.libraryManagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.libraryManagement.enumeration.BookStatus;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="book_details")
@ToString
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="b_id")
    private int bookId;
    @Column(name="book_name")
    private String bookname;
    @Column(name="author_name")
    private String authorname;

    @Column(name="issue_date")
    private Date issuedDate;
   @Enumerated(value = EnumType.STRING)
    @Column(name = "Book_status")
    private BookStatus status ;
    @JsonManagedReference
   @OneToMany(fetch=FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "s_id" )
   private List<Student> student= new ArrayList<>();


}
