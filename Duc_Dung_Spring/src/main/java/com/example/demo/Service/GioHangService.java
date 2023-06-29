package com.example.demo.Service;

import com.example.demo.entity.GioHang;

import java.util.List;

public interface GioHangService {
    List<GioHang> findAll();

    List<GioHang> checkData();

    GioHang findByTinhTrang0();

    List<GioHang> findByTinhTrang(Integer tinhTrang);

    void themGioHang(GioHang gioHang);

    void updateGioHang(GioHang gioHang);

    void daNhanDuocHang(GioHang gioHang);

    void xacNhan(GioHang gioHang);

    void removeGioHang(String id);

    GioHang findById(String id);

    GioHang findByMa(String ma);


}
