package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "MonHoc")
public class MonHoc {
    @Id
    @Column(name = "MaMH")
    private String MaMH;

    @Column(name = "TenMH")
    private String TenMH;

    @Column(name = "so_tin_chi")
    private Integer soTinChi;


    @OneToMany(cascade =   CascadeType.ALL,fetch = FetchType.EAGER)
    private Collection<Diem> diem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonHoc monHoc)) return false;
        return Objects.equals(getMaMH(), monHoc.getMaMH()) && Objects.equals(getTenMH(), monHoc.getTenMH()) && Objects.equals(getSoTinChi(), monHoc.getSoTinChi()) && Objects.equals(getDiem(), monHoc.getDiem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaMH(), getTenMH(), getSoTinChi(), getDiem());
    }

    public MonHoc(String maMH, String tenMH, Integer soTinChi, Collection<Diem> diem) {
        MaMH = maMH;
        TenMH = tenMH;
        this.soTinChi = soTinChi;
        this.diem = diem;
    }

    public MonHoc() {
    }
}
