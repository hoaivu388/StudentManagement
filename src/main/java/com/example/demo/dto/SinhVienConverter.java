package com.example.demo.dto;

import com.example.demo.model.SinhVien;

import java.text.SimpleDateFormat;

public class SinhVienConverter {


    public static SinhVienForm convertToSinhVienForm(SinhVien sinhVien) {
        SinhVienForm sinhVienForm = new SinhVienForm();
        sinhVienForm.setMaSV(sinhVien.getMaSV());
        sinhVienForm.setTenSV(sinhVien.getTenSV());
        sinhVienForm.setGioiTinh(sinhVien.getGioiTinh());
        sinhVienForm.setNgaySinh(sinhVien.getNgaySinh());
        sinhVienForm.setQueQuan(sinhVien.getQueQuan());
        // Set other fields accordingly
        sinhVienForm.setMalop(sinhVien.getLops().getMalop()); // Assuming you have a getMaLop() method in the Lop class
        sinhVienForm.setPhoneNumber(sinhVien.getPhoneNumber());
        return sinhVienForm;
    }
}
