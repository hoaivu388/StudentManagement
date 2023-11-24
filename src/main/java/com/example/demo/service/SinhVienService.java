package com.example.demo.service;

import com.example.demo.dto.DiemDTO;
import com.example.demo.dto.SinhVienDTO;
import com.example.demo.dto.SinhVienForm;
import com.example.demo.model.SinhVien;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SinhVienService {
    void insertSinhVien(
            String in_MaSV,
            String in_TenSV,
            String in_GioiTinh,
            String in_NgaySinh,
            String in_QueQuan,
            String in_Malop,
            String in_PhoneNumber
    );
    void deleteSinhVienById( String masv);
    void updateSinhVien(
             String maSV,
             String tenSV,
             String gioiTinh,
             String ngaySinh,
            String queQuan,
             String malop,
             String phoneNumber
    );
    SinhVien findSinhVienByMaSV(String id);
    Double AvgScore(String id, int hk);
    int totalCre(String id);
    List<SinhVienDTO> getAllSinhVien();
    List<DiemDTO> viewPoint(String id, int hk);

    void assign( String masv, String malop);
}
