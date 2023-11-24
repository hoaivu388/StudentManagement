package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "Lop")
public class Lop {
    @Column(name = "id", nullable = true, length = 36)
    private String id;

    @Id
    @Column(name = "Malop", nullable = false, unique = true)
    private String Malop;

    @Column(name = "TenLop")
    private String TenLop;


    @OneToMany(mappedBy = "lops",fetch = FetchType.EAGER,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Collection<SinhVien> sinhViens;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "MaKhoaHoc")
    private KhoaHoc khoaHocs;


    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "MaHeDt")
    private HeDT heDT;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "Makhoa")
    private Khoa khoa;

    public Lop(String id, String malop, String tenLop, Collection<SinhVien> sinhViens, KhoaHoc khoaHocs, HeDT heDT, Khoa khoa) {
        this.id = id;
        Malop = malop;
        TenLop = tenLop;
        this.sinhViens = sinhViens;
        this.khoaHocs = khoaHocs;
        this.heDT = heDT;
        this.khoa = khoa;
    }

    public Lop() {
    }
}
