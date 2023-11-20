package com.example.demo.service;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface LopService {
    int getTotalSinhVien(String id);

    String getClass(String id);


    void insertLop(
             String in_Malop,
             String in_TenLop,
             String in_Makhoa,
             String in_MaHeDt,
             String in_MaKhoahoc
    );

}
