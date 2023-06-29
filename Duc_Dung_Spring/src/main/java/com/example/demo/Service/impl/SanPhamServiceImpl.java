package com.example.demo.Service.impl;

import com.example.demo.Service.SanPhamService;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository repo;

    @Override
    public List<SanPham> findAll() {
        return repo.findAll();
    }

    @Override
    public void saveOrUpdate(SanPham sp) {
        repo.save(sp);
    }

    @Override
    public void removeNSX(String id) {
        Boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public SanPham findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }
}
