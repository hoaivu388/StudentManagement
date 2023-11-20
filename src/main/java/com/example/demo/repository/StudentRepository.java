package com.example.demo.repository;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = "SELECT " +
            "s.student_id as student_id, " +
            "s.first_name as first_name, " +
            "s.last_name as last_name, " +
            "s.email as email, " +
            "st.phone_number as phone_number, " +
            "st.address as address, " +
            "st.grade as grade, " +
            "st.date_of_birth as date_of_birth " +
            "FROM student s " +
            "INNER JOIN studentdetail st " +
            "ON s.id = st.id", nativeQuery = true)
    public List<StudentDTO> showStudent();

    @Procedure(value = "ShowAllStudentsWithDetails")
    public List<Student> ShowAllStudentsWithDetails();



}
