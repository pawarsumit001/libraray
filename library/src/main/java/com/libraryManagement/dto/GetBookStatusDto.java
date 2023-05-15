package com.libraryManagement.dto;

import com.libraryManagement.entity.Student;
import com.libraryManagement.enumeration.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetBookStatusDto {
    private BookStatus status ;
    private List<Student> student;

}
