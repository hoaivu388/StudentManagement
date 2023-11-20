package com.example.demo.service;

import com.example.demo.repository.LopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LopServiceImpl implements LopService{
    private final LopRepository lopRepository;
    @Autowired
    public LopServiceImpl(LopRepository lopRepository) {
        this.lopRepository = lopRepository;
    }

    @Override
    public int getTotalSinhVien(String id) {
        return lopRepository.getTotalSinhVien(id);
    }

    @Override
    public String getClass(String id) {
        return lopRepository.getClass(id);
    }

    @Override
    public void insertLop(String in_Malop, String in_TenLop, String in_Makhoa, String in_MaHeDt, String in_MaKhoahoc) {
        lopRepository.insertLop(in_Malop,in_TenLop,in_Makhoa,in_MaHeDt,in_MaKhoahoc);
    }

}
