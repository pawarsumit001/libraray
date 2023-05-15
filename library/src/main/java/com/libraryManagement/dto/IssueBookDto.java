package com.libraryManagement.dto;

import com.libraryManagement.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IssueBookDto {
    private Date issuedDate;
    private int bookId;
    private String bookName;
    private String name;

}
