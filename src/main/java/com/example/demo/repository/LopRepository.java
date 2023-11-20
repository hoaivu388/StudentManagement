package com.example.demo.repository;

import com.example.demo.model.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LopRepository extends JpaRepository<Lop,String> {
    @Query(value = "select GetNumberOfStudentsInClass(?1)",nativeQuery = true)
    int getTotalSinhVien(String id);


    @Query(value = "select GetClassByStudentID(?1)",nativeQuery = true)
    String getClass(String id);

    @Procedure(name = "InsertLop")
    void insertLop(
            @Param("Malop") String in_Malop,
            @Param("TenLop") String in_TenLop,
            @Param("Makhoa") String in_Makhoa,
            @Param("MaHeDt") String in_MaHeDt,
            @Param("MaKhoahoc") String in_MaKhoahoc
    );
}
