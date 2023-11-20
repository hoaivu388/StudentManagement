package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "Khoa")
public class Khoa {

    @Id
    @Column(name = "Makhoa", nullable = false, length = 255)
    private String makhoa;

    @Column(name = "Tenkhoa")
    private String tenkhoa;

    @Column(name = "id", nullable = true, length = 36)
    private String id;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Collection<Lop> lops;
    // Constructors, getters, and setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Khoa khoa = (Khoa) o;
        return Objects.equals(makhoa, khoa.makhoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(makhoa);
    }

    public Khoa() {
    }

    public Khoa(String makhoa, String tenkhoa, String id, Collection<Lop> lops) {
        this.makhoa = makhoa;
        this.tenkhoa = tenkhoa;
        this.id = id;
        this.lops = lops;
    }
}
