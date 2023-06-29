package com.example.demo.Service.impl;

import com.example.demo.Service.CuaHangService;
import com.example.demo.entity.CuaHang;
import com.example.demo.repository.CuaHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepository repo;

    @Override
    public List<CuaHang> findAll() {
        return repo.findAll();
    }

    @Override
    public void saveOrUpdate(CuaHang ch) {
        repo.save(ch);
    }

    @Override
    public void removeCuaHang(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public CuaHang findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }
}
