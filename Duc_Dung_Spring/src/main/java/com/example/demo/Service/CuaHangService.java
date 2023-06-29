package com.example.demo.Service;

import com.example.demo.entity.CuaHang;

import java.util.List;

public interface CuaHangService {
    List<CuaHang> findAll();

    void saveOrUpdate(CuaHang cv);

    void removeCuaHang(String id);

    CuaHang findById(String id);
}
