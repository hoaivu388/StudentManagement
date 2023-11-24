package com.example.demo.embedded;


import com.example.demo.model.MonHoc;
import com.example.demo.model.SinhVien;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class DiemId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "MaSV",insertable = false, updatable = false)
    private SinhVien sinhVien;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "MaMH",insertable = false, updatable = false)
    private MonHoc monHoc;
}
