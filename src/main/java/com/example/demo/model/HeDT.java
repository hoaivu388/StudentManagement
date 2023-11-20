package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "HeDt")
public class HeDT {

    @Id
    @Column(name = "MaHeDt", nullable = false, length = 255)
    private String maHeDt;

    @Column(name = "TenHeDt")
    private String tenHeDt;

    // Constructors, getters, and setters
    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Collection<Lop> lops;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeDT heDT = (HeDT) o;
        return Objects.equals(maHeDt, heDT.maHeDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHeDt);
    }


    public HeDT(String maHeDt, String tenHeDt, Collection<Lop> lops) {
        this.maHeDt = maHeDt;
        this.tenHeDt = tenHeDt;
        this.lops = lops;
    }

    public HeDT() {
    }
}
