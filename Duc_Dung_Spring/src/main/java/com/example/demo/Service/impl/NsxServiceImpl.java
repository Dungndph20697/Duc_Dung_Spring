package com.example.demo.Service.impl;

import com.example.demo.Service.NsxService;
import com.example.demo.entity.NSX;
import com.example.demo.repository.NSXRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsxServiceImpl implements NsxService {
    @Autowired
    private NSXRepository repo;

    @Override
    public List<NSX> findAll() {
        return repo.findAll();
    }

    @Override
    public void saveOrUpdate(NSX nsx) {
        repo.save(nsx);
    }

    @Override
    public void removeNSX(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public NSX findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById" + id));
    }
}
