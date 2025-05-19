package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(studentDetails.getName());
        existing.setRollNumber(studentDetails.getRollNumber());
        existing.setEmail(studentDetails.getEmail());
        existing.setDepartment(studentDetails.getDepartment());
        existing.setAge(studentDetails.getAge());
        existing.setDob(studentDetails.getDob());

        return studentRepository.save(existing);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
