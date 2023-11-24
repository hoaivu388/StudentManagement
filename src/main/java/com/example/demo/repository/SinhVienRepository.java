package com.example.demo.repository;

import com.example.demo.dto.DiemDTO;
import com.example.demo.dto.SinhVienDTO;
import com.example.demo.dto.SinhVienForm;
import com.example.demo.model.SinhVien;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,String> {

    @Procedure(value = "InsertSinhVien")
    void insertSinhVien(
            @Param("MaSV") String in_MaSV,
            @Param("TenSV") String in_TenSV,
            @Param("gioi_tinh") String in_GioiTinh,
            @Param("ngay_sinh") String in_NgaySinh,
            @Param("que_quan") String in_QueQuan,
            @Param("Malop") String in_Malop,
            @Param("phone_number") String in_PhoneNumber
    );
    @Procedure(value = "DeleteSinhVien")
    void deleteSinhVienById(@Param("MaSV") String masv);
    @Procedure(name = "updateSinhVien")
    void updateSinhVien(
            @Param("MaSV") String maSV,
            @Param("TenSV") String tenSV,
            @Param("gioi_tinh") String gioiTinh,
            @Param("ngay_sinh") String ngaySinh,
            @Param("que_quan") String queQuan,
            @Param("Malop") String malop,
            @Param("phone_number") String phoneNumber
    );
    @Procedure(value = "GetStudentScoresBySemesterAndSubject")
    List<DiemDTO> viewPoint(@Param("MaSV") String id, @Param("hoc_ky") int hk);
    @Procedure(value = "GetSinhVienDetailsByMaSV")
    SinhVien findSinhVienByMaSV(@Param("MaSV") String id);
    @Procedure(value = "AssignStudentToClass")
    void AssignStudent(@Param("MaSV") String masv, @Param("MaLop") String malop);

    @Query(value = "select CalculateAverageScore(?1, ?2)",nativeQuery = true)
    Double AvgScore(String id, int hk);

    @Query(value = "select CalculateTotalCredits(?1)",nativeQuery = true)
    int totalCre(String id);
    @Procedure(value = "ShowStudentDetails")
    List<SinhVienDTO> getAllSinhVien();
}
