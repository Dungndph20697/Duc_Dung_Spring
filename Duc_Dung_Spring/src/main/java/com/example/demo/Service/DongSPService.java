package com.example.demo.Service;

import com.example.demo.entity.DongSP;

import java.util.List;

public interface DongSPService {
    List<DongSP> findAll();

    void saveOrUpdate(DongSP dongSP);

    void removeNSX(String id);

    DongSP findById(String id);
}
