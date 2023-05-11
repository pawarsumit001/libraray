package com.libraryManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="student_details")
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="s_id")
    private int id;
    @Column(name="student_name")
    private String name;
    @Column(name="student_address")
    private String address;
    @Column(name="mobile")
    private String mobile;
    @Column(name="book_issuedate")
    private Date bookIssue;

    @ManyToOne(fetch = FetchType.EAGER ,cascade =  CascadeType.ALL)
    @JsonBackReference

    private Book book;


}
