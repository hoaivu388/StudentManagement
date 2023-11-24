package com.example.demo.model;

import com.example.demo.embedded.DiemId;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "Diem")
public class Diem {
    @EmbeddedId
    private DiemId id;

    @Column(name = "diem_lan1")
    private Double dieml1;

    @Column(name = "diem_lan2")
    private Double dieml2;
    @Column(name = "hoc_ky")
    private Integer hocky;

    public Diem(DiemId id, Double dieml1, Double dieml2, Integer hocky) {
        this.id = id;
        this.dieml1 = dieml1;
        this.dieml2 = dieml2;
        this.hocky = hocky;
    }

    public Diem() {
    }
}
