package com.example.demo.Service;

import com.example.demo.entity.ChucVu;

import java.util.List;

public interface ChucVuService {
    List<ChucVu> findAll();

    void saveOrUpdate(ChucVu cv);

    void removeChucVu(String id);

    ChucVu findById(String id);
}
