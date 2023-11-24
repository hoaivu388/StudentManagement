package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "MaMH",
        "TenMH",
        "dieml1",
        "dieml2"

})
public interface DiemDTO {
    String getMaMH();
    String getTenMH();

    Double getDieml1();
    Double getDieml2();
}
