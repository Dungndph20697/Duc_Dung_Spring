package com.example.demo.Service;

import com.example.demo.entity.ChiTietSP;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ChiTietSPService {
    List<ChiTietSP> findAll();

    List<ChiTietSP> search(String tenSp);

    Page<ChiTietSP> phanTrang(Optional<Integer> soTrang);

    void saveOrUpdate(ChiTietSP nsx);

    void removeNSX(String id);

    ChiTietSP findById(String id);
}
