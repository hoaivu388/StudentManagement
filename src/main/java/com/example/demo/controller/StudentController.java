package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/show")
    public List<StudentDTO> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("showall")
    public List<Student> getStudent(){
        return this.studentService.ShowAllStudentsWithDetails();
    }

}
