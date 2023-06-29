package com.example.demo.Service;

import com.example.demo.entity.NhanVien;

import java.util.List;

public interface NhanVienService {
    List<NhanVien> findAll();

    void saveOrUpdate(NhanVien nhanVien);

    void removeNV(String id);

    NhanVien findById(String id);
}
