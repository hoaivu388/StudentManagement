package com.example.demo.controller;

import com.example.demo.dto.DiemDTO;
import com.example.demo.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestControler {
    private final SinhVienService sinhVienService;
    @Autowired
    public TestControler(SinhVienService sinhVienService) {
        this.sinhVienService = sinhVienService;
    }
    @GetMapping("/show/{id}/{hk}")
    public List<DiemDTO> getAll(@PathVariable String id, @PathVariable int hk){
        return sinhVienService.viewPoint(id, hk);
    }
}
