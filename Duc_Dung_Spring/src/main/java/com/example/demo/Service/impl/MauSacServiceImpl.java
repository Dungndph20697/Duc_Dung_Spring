package com.example.demo.Service.impl;

import com.example.demo.Service.MauSacService;
import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository repo;

    @Override
    public List<MauSac> findAll() {
        return repo.findAll();
    }

    @Override
    public void addMauSac(MauSac ms) {
        repo.save(ms);
    }

    @Override
    public void updateMauSac(MauSac ms) {
        repo.save(ms);
    }

    @Override
    public void removeMauSac(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public MauSac findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }
}
