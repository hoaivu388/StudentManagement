package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@NamedStoredProcedureQuery(
        name = "ShowAllStudentsWithDetails",
        procedureName = "ShowAllStudentsWithDetails",
        resultClasses = {Student.class},
        parameters = {}
)

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="student_id")
    private String studentId;

    @OneToMany(mappedBy = "student",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private StudentDetail studentDetail;

    public Student(Integer id, String firstName, String lastName, String email, String studentId, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentId = studentId;
        this.courses = courses;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void addCourse(Course course) {
        courses.add(course);
        course.setStudent(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.setStudent(null);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(studentId, student.studentId) && Objects.equals(courses, student.courses) && Objects.equals(studentDetail, student.studentDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, studentId, courses, studentDetail);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                ", studentDetail=" + studentDetail +
                '}';
    }
}
