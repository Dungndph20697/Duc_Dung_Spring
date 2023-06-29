package com.example.demo.Service.impl;

import com.example.demo.Service.ChucVuService;
import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository repo;

    @Override
    public List<ChucVu> findAll() {
        return repo.findAll();
    }

    @Override
    public void saveOrUpdate(ChucVu cv) {
        repo.save(cv);
    }

    @Override
    public void removeChucVu(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public ChucVu findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }
}
