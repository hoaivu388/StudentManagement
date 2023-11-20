package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "SinhVien")

public class SinhVien {

    @Id
    @Column(name = "MaSV", nullable = false, length = 50)
    private String maSV;

    @Column(name = "TenSV")
    private String tenSV;

    @Column(name = "gioi_tinh")
    private String gioiTinh;


    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "que_quan")
    private String queQuan;


    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "Malop")
    private Lop lops;

    // Constructors, getters, and setters


    public SinhVien(String maSV, String tenSV, String gioiTinh, String ngaySinh, String queQuan, String phoneNumber, Lop lops) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.phoneNumber = phoneNumber;
        this.lops = lops;
    }

    public SinhVien() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien sinhVien = (SinhVien) o;
        return Objects.equals(maSV, sinhVien.maSV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSV);
    }


}
