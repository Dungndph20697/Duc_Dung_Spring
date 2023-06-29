package com.example.demo.Service;

import com.example.demo.entity.MauSac;

import java.util.List;

public interface MauSacService {
    List<MauSac> findAll();

    void addMauSac(MauSac ms);

    void updateMauSac(MauSac ms);

    void removeMauSac(String id);

    MauSac findById(String id);

}
