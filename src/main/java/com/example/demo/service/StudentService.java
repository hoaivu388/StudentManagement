package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    public List<Student> ShowAllStudentsWithDetails();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);

    public List<Student> getAllStudentsNotFirstName(String name);

}
