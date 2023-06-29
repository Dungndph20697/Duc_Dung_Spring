package com.example.demo.Service.impl;

import com.example.demo.Service.ChiTietSPService;
import com.example.demo.entity.ChiTietSP;
import com.example.demo.repository.ChiTietSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    private ChiTietSPRepository repo;

    @Override
    public List<ChiTietSP> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ChiTietSP> search(String search) {
        return repo.search(search);
    }

    @Override
    public Page<ChiTietSP> phanTrang(Optional<Integer> soTrang) {
        PageRequest pageRequest = PageRequest.of(soTrang.orElse(0), 5);
        return repo.findAll(pageRequest);
    }

    @Override
    public void saveOrUpdate(ChiTietSP ctsp) {
        repo.save(ctsp);
    }

    @Override
    public void removeNSX(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public ChiTietSP findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }
}
