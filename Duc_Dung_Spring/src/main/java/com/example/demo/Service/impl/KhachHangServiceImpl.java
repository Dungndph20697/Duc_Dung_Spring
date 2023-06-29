package com.example.demo.Service.impl;

import com.example.demo.Service.KhachHangService;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository repo;

    @Override
    public List<KhachHang> findAll() {
        List<KhachHang> list = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (KhachHang kh : repo.findAll()) {
            String date = localDate.format(dateFormat);
            kh.setNgaySinh(date);
            list.add(kh);
        }
        return list;
    }

    @Override
    public void saveOrUpdate(KhachHang kh) {
        repo.save(kh);
    }

    @Override
    public void removeKH(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public KhachHang findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }
}
