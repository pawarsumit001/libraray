package com.libraryManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="student_details")
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "book_id")
    @JsonBackReference

    private Book book;


}

