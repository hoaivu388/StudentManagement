package com.example.demo.controller;

import com.example.demo.service.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lop")
public class LopController {
    private final LopService lopService;
    @Autowired
    public LopController(LopService lopService) {
        this.lopService = lopService;
    }

    @GetMapping("/getclass/{id}")
    public String getclass(@PathVariable String id){
        return lopService.getClass(id);
    }
    @GetMapping("/total/{id}")
    public int getTotal(@PathVariable String id){
        return lopService.getTotalSinhVien(id);
    }
    @PostMapping("/insert")
    public ResponseEntity<String> insert(
            @RequestParam("MaLop") String malop,
            @RequestParam("TenLop") String tenlop,
            @RequestParam("MaKhoa") String makhoa,
            @RequestParam("MaHeDt") String mahedt,
            @RequestParam("MaKhoahoc") String mkh
    ) {

        try {
            lopService.insertLop(malop,tenlop,makhoa,mahedt,mkh);
            return new ResponseEntity<>("Lop insert successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error inserting Lop: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
