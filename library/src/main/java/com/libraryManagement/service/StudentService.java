package com.libraryManagement.service;

import com.libraryManagement.dto.ViewStudentDto;
import com.libraryManagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    public List<Student> addStudent(List<Student> student);

    List<Student> viewAllStudent();

    public Optional<Student> viewByStudentId(int id);

    public void deleteStudentById(int id);

    public Student updateStudentById(Student student ,int id);


}
