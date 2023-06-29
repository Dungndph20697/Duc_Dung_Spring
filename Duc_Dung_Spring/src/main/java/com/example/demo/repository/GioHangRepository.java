package com.example.demo.repository;

import com.example.demo.entity.GioHang;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GioHangRepository extends JpaRepository<GioHang, String> {

    @Query("select gh from GioHang gh where gh.tinhTrang=0")
    List<GioHang> checkData();

    @Query("select gh from GioHang gh where gh.ma=:ma")
    GioHang findByMa(@Param("ma") String ma);

    @Query("select  gh from GioHang gh where gh.tinhTrang = 0")
    GioHang findByTinhTrang0();

    @Query("select  gh from GioHang gh where gh.tinhTrang = :tinhTrang")
    List<GioHang> findByTinhTrang(@Param("tinhTrang") Integer tinhTrang);


//    @Transactional
//    @Modifying
//    @Query(value = "update GioHang set tinhTrang = 1 where id = :id",nativeQuery = true)
//    void xacNhan(@Param("id") String id);
}
