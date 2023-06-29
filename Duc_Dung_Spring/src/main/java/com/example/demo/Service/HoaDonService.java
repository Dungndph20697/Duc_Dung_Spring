package com.example.demo.Service;

import com.example.demo.entity.HoaDon;

import java.util.List;

public interface HoaDonService {
    List<HoaDon> findAll();

    void saveOrUpdate(HoaDon hoaDon);

    void removeHoaDon(String id);

    HoaDon findById(String id);
}
