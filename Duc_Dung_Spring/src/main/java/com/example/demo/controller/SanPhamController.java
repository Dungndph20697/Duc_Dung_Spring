package com.example.demo.controller;

import com.example.demo.Service.SanPhamService;
import com.example.demo.entity.SanPham;
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
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService service;

    @GetMapping("/find-all")
    public List<SanPham> findAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    public void addSanPham(@RequestBody SanPham sp) {
        service.saveOrUpdate(sp);
    }

    @PutMapping("/update")
    public void updateSanPham(@RequestBody SanPham sp) {
        service.saveOrUpdate(sp);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteSanPham(@PathVariable String id) {
        service.removeNSX(id);
    }

    @GetMapping("/find-by-id/{id}")
    public SanPham findById(@PathVariable String id) {
        return service.findById(id);
    }
}
