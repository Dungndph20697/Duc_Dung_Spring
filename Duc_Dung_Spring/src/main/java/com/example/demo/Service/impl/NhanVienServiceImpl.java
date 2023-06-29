package com.example.demo.Service.impl;

import com.example.demo.Service.NhanVienService;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository repo;

    @Override
    public List<NhanVien> findAll() {
        return repo.findAll();
    }

    @Override
    public void saveOrUpdate(NhanVien nhanVien) {
        repo.save(nhanVien);
    }

    @Override
    public void removeNV(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public NhanVien findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }
}
