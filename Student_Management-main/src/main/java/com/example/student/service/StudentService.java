package com.example.student.service;

import com.example.student.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    Student updateStudent(Long id, Student studentDetails);
    List<Student> getAllStudents();
}
