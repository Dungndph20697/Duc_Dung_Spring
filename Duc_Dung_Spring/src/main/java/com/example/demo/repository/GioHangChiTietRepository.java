package com.example.demo.repository;

import com.example.demo.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, String> {

    @Query("select ghct from GioHangChiTiet ghct where ghct.chiTietSP.id =:idCtsp and ghct.gioHang.id = :idGioHang")
    GioHangChiTiet checkData(@Param("idCtsp") String idCtsp, @Param("idGioHang") String idGioHang);

//    @Query(value = "select * from GioHangChiTiet ghct where ghct.id in \n" +
//            "(select ghct2.id from GioHangChiTiet ghct2 join GioHang on GioHang.Id = ghct2.IdGioHang \n" +
//            "where GioHang.TinhTrang=0) and ghct.id = :idGHCT",nativeQuery = true)
//    GioHangChiTiet checkData(@Param("idGHCT") String idGhct);

    @Query("select ghct from GioHangChiTiet ghct where ghct.gioHang.tinhTrang = :trangThai")
    List<GioHangChiTiet> getAllByTrangThai(@Param("trangThai") Integer trangThai);

    @Query("select ghct from GioHangChiTiet ghct where ghct.gioHang.tinhTrang = 1 or ghct.gioHang.tinhTrang = 2")
    List<GioHangChiTiet> getTrangThai();

    //    @Query("select ghct from GioHangChiTiet ghct where ghct.gioHang.tinhTrang = 1")
//    List<GioHangChiTiet> getAllByTrangThai1();
    @Query("select ghct from GioHangChiTiet ghct where ghct.gioHang.tinhTrang <> 0")
    List<GioHangChiTiet> sanPhamDaMua();
}
