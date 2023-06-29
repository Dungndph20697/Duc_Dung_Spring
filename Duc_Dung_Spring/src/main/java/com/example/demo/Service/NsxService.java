package com.example.demo.Service;

import com.example.demo.entity.NSX;

import java.util.List;

public interface NsxService {
    List<NSX> findAll();

    void saveOrUpdate(NSX nsx);

    void removeNSX(String id);

    NSX findById(String id);
}
