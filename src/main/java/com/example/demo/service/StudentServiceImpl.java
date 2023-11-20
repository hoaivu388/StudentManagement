package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.showStudent();
    }
    @Transactional
    public List<Student> ShowAllStudentsWithDetails() {
        return studentRepository.ShowAllStudentsWithDetails();
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public List<Student> getAllStudentsNotFirstName(String name) {
        return null;
    }
}
