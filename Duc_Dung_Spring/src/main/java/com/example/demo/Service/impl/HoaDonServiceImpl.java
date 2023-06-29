package com.example.demo.Service.impl;

import com.example.demo.Service.HoaDonService;
import com.example.demo.entity.HoaDon;
import com.example.demo.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private HoaDonRepository repo;

    @Override
    public List<HoaDon> findAll() {
        return repo.findAll();
    }

    @Override
    public void saveOrUpdate(HoaDon hoaDon) {
        hoaDon.setNgayTao(Date.valueOf(LocalDate.now()));
        repo.save(hoaDon);
    }

    @Override
    public void removeHoaDon(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public HoaDon findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }

}
