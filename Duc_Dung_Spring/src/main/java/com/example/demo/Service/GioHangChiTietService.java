package com.example.demo.Service;

import com.example.demo.entity.ChiTietSP;
import com.example.demo.entity.GioHangChiTiet;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface GioHangChiTietService {
    List<GioHangChiTiet> findAll();

    List<GioHangChiTiet> sanPhamDaMua();

    List<GioHangChiTiet> findByTinhTrang1();

    List<GioHangChiTiet> findByTinhTrang();

    List<GioHangChiTiet> dangGiao();

    BigDecimal tinhTongTien();

    void saveOrUpdate(GioHangChiTiet gioHangChiTiet);

    void removeGhct(String id);

    GioHangChiTiet findById(String id);
}
