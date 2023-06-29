package com.example.demo.Service.impl;

import com.example.demo.Service.DongSPService;
import com.example.demo.entity.DongSP;
import com.example.demo.repository.DongSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DongSPServiceImpl implements DongSPService {
    @Autowired
    private DongSPRepository repo;

    @Override
    public List<DongSP> findAll() {
        return repo.findAll();
    }

    @Override
    public void saveOrUpdate(DongSP dongSP) {
        repo.save(dongSP);
    }

    @Override
    public void removeNSX(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public DongSP findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById" + id));
    }
}
