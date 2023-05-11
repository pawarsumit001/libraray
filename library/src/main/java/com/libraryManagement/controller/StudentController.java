package com.libraryManagement.controller;

import com.libraryManagement.entity.Student;
import com.libraryManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/addStudent")
    public List<Student> AddStudent(@RequestBody List<Student> student ){
         List<Student> st= studentService.addStudent(student);
        return st;
    }
    @GetMapping("/viewStudent/{id}")
    public Optional<Student> viewStudent(@PathVariable("id") int id ){
        return  studentService.viewByStudentId(id);
    }
    @GetMapping("/viewAll")
    public List<Student> viewAllStudent( ){
        return studentService.viewAllStudent();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudentById(id);

    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, int id){
        return this.studentService.updateStudentById(student,id);
    }

}
