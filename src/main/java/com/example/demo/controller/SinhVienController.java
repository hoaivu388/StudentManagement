package com.example.demo.controller;

import com.example.demo.dto.SinhVienConverter;
import com.example.demo.dto.SinhVienDTO;
import com.example.demo.dto.SinhVienForm;
import com.example.demo.model.SinhVien;
import com.example.demo.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SinhVienController {

    private final SinhVienService sinhVienService;

    @Autowired
    public SinhVienController(SinhVienService sinhVienService) {
        this.sinhVienService = sinhVienService;
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        List<SinhVienDTO> sinhVienDTOS = sinhVienService.getAllSinhVien();
        model.addAttribute("SinhVienDTO", sinhVienDTOS);
        return "student/students";
    }
    @GetMapping("/find/{id}")
    public  SinhVien findById(@PathVariable String id){
        return sinhVienService.findSinhVienByMaSV(id);
    }
    @GetMapping("/totalCre/{id}")
    public int gettotalCre(@PathVariable String id){
        return sinhVienService.totalCre(id);
    }
    @GetMapping("/avg/{id}/{hk}")
    public Double tinhdiemtb(@PathVariable String id, @PathVariable int hk){
        return sinhVienService.AvgScore(id,hk);
    }
    @GetMapping("/delete/{id}")
    public String  deleteSinhVien(
            @PathVariable String id) {

        try {
            sinhVienService.deleteSinhVienById(id);
            return "redirect:/getAll";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
    @PostMapping("/ok")
    public String updateSinhVien(@ModelAttribute("sinhVienUp") SinhVienForm sinhVien) {
        try {

                sinhVienService.updateSinhVien(
                        sinhVien.getMaSV(),
                        sinhVien.getTenSV(),
                        sinhVien.getGioiTinh(),
                        sinhVien.getNgaySinh(),
                        sinhVien.getQueQuan(),
                        sinhVien.getMalop(),
                        sinhVien.getPhoneNumber()
                );
                return "redirect:/getAll";
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return "redirect:/error";
        }
    }


    // In your controller
    @GetMapping("/create")
    public String create(Model model) {
        SinhVienForm sinhVienForm = new SinhVienForm();
        model.addAttribute("sinhVienForm", sinhVienForm);
        return "student/insert_form";
    }


    @GetMapping("/pre")
    public String uplink(@RequestParam("id")  String id, Model model) {
        SinhVien SinhVien =  sinhVienService.findSinhVienByMaSV(id);
        SinhVienForm sinhVienForm = SinhVienConverter.convertToSinhVienForm(SinhVien);
        model.addAttribute("sinhVienUp", sinhVienForm);
        return "/student/update";
    }

    @PostMapping("/insert")
    public String insertSinhVien(@ModelAttribute("sinhVienForm") SinhVienForm sinhVien) {
        try {
            sinhVienService.insertSinhVien(
                    sinhVien.getMaSV(),
                    sinhVien.getTenSV(),
                    sinhVien.getGioiTinh(),
                    sinhVien.getNgaySinh(),
                    sinhVien.getQueQuan(),
                    sinhVien.getMalop(),
                    sinhVien.getPhoneNumber()
            );
            return "redirect:/getAll";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PutMapping("/assign")
    public ResponseEntity<String> assignSinhVien(
            @RequestParam("MaSV") String masv,
            @RequestParam("MaLop") String malop
    ) {

        try {
            sinhVienService.assign(masv,malop);
            return new ResponseEntity<>("SinhVien assigned successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error assigning SinhVien: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
