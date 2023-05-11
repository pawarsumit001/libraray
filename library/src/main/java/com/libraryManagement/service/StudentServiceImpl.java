package com.libraryManagement.service;

import com.libraryManagement.entity.Student;
import com.libraryManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> addStudent(List<Student> student) {
        return this.studentRepository.saveAll(student);
    }

    @Override
    public List<Student> viewAllStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> viewByStudentId(int id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public void deleteStudentById(int id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudentById(Student student ,int id) {
        student.setId(id);
        return this.studentRepository.save(student);
    }
}
