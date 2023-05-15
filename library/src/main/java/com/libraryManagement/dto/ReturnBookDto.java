package com.libraryManagement.dto;

import javax.persistence.Column;
import java.util.Date;

public class ReturnBookDto {
    private int bookId;

    private String bookname;

    private String authorname;


    private Date issuedDate;

    private Date returnDate;
    private String name;
}
