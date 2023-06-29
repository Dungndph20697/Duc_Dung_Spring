package com.example.demo.Service;

import com.example.demo.entity.HoaDonChiTiet;

import java.util.List;

public interface HoaDonChiTietService {
    List<HoaDonChiTiet> findAll();

    void saveOrUpdate(HoaDonChiTiet hoaDonChiTiet);

    void removeHDCT(String id);

    HoaDonChiTiet findById(String id);
}
