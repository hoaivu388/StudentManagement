package com.example.demo.dto;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;


    public interface StudentDTO {
        String getStudent_id();
        String getFirst_name();
        String getLast_name();
        String getEmail();
        String getPhone_number();
        String getAddress();
        Integer getGrade();
        Date getDate_of_birth();
    }


