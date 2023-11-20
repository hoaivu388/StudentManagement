package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;
@JsonPropertyOrder({
        "maSV",
        "tenSV",
        "gioiTinh",
        "ngaySinh",
        "queQuan",
        "malop",
        "tenLop",
        "tenHeDt",
        "maKhoaHoc",
        "tenkhoa",
        "phoneNumber"
})

public interface SinhVienDTO {
    String getMaSV();
    String getTenSV();
    String getGioiTinh();
    String getNgaySinh();
    String getQueQuan();
    String getMalop();
    String getTenLop();
    String getTenHeDt();
    String getMaKhoaHoc();
    String getTenkhoa();
    String getPhoneNumber();





}
