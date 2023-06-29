package com.example.demo.Service;

import com.example.demo.entity.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> findAll();

    void saveOrUpdate(KhachHang kh);

    void removeKH(String id);

    KhachHang findById(String id);
}
