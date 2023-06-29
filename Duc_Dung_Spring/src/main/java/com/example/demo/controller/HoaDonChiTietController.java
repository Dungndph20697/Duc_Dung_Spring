package com.example.demo.controller;

import com.example.demo.Service.HoaDonChiTietService;
import com.example.demo.entity.HoaDonChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {
    @Autowired
    private HoaDonChiTietService service;

    @GetMapping("/find-all")
    public List<HoaDonChiTiet> findAll() {
        return service.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public HoaDonChiTiet findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    public void addHDCT(@RequestBody HoaDonChiTiet hdct) {
        service.saveOrUpdate(hdct);
    }

    @PutMapping("/update")
    public void updateHDCT(@RequestBody HoaDonChiTiet hdct) {
        service.saveOrUpdate(hdct);
    }

    @DeleteMapping("/remove/{id}")
    public void removeHDCT(@PathVariable String id) {
        service.removeHDCT(id);
    }
}
