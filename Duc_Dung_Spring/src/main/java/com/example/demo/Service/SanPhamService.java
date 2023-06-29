package com.example.demo.Service;

import com.example.demo.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> findAll();

    void saveOrUpdate(SanPham sp);

    void removeNSX(String id);

    SanPham findById(String id);
}
