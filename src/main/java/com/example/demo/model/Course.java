package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="course_name")
    private String courseName;
    @Column(name="course_id")
    private String courseId;
    @Column(name="credit")
    private Integer credit;

    @ManyToOne()
    @JoinColumn(name="student_id")
    private Student student;

    public Course(String courseName, String courseId, Integer credit) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.credit = credit;
    }

    public Course(Integer id, String courseName, String courseId, Integer credit) {
        this.id = id;
        this.courseName = courseName;
        this.courseId = courseId;
        this.credit = credit;
    }

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Student getStudent() {
        return student;
    }



    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", credit=" + credit +
                ", student=" + student +
                '}';
    }
    // In the Course entity
    public void setStudent(Student student) {
        if (this.student != null) {
            this.student.getCourses().remove(this);
        }
        this.student = student;
        if (student != null) {
            student.getCourses().add(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(getId(), course.getId()) && Objects.equals(getCourseName(), course.getCourseName()) && Objects.equals(getCourseId(), course.getCourseId()) && Objects.equals(getCredit(), course.getCredit()) && Objects.equals(getStudent(), course.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCourseName(), getCourseId(), getCredit(), getStudent());
    }
}
