package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="studentdetail")
public class StudentDetail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name="address")
    private String address;
    @Column(name = "grade")
    private Integer grade;
    @Column(name = "date_of_birth")
    private Date dateofbirth;

    @OneToOne(mappedBy = "studentDetail", cascade = CascadeType.ALL)
    private Student student;

    public StudentDetail() {
    }

        public StudentDetail(Integer id, String phoneNumber, String address, Integer grade, Date dateofbirth, Student student) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.grade = grade;
        this.dateofbirth = dateofbirth;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", grade=" + grade +
                ", dateofbirth=" + dateofbirth +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDetail that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getGrade(), that.getGrade()) && Objects.equals(getDateofbirth(), that.getDateofbirth()) && Objects.equals(getStudent(), that.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhoneNumber(), getAddress(), getGrade(), getDateofbirth(), getStudent());
    }
}
