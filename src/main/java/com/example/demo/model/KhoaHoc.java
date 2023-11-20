package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "KhoaHoc")
public class KhoaHoc {
    @Id
    @Column(name = "MaKhoaHoc", nullable = false, unique = true)
    private String MaKhoaHoc;

    @Column(name = "TenKhoaHoc")
    private String TenKhoaHoc;

    @Column(name = "id", nullable = true, length = 36)
    private String id;

    @OneToMany
    private Collection<Lop> lops;

    public KhoaHoc(String maKhoaHoc, String tenKhoaHoc, String id, Collection<Lop> lops) {
        MaKhoaHoc = maKhoaHoc;
        TenKhoaHoc = tenKhoaHoc;
        this.id = id;
        this.lops = lops;
    }

    public KhoaHoc() {
    }


}
