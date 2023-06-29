package com.example.demo.controller;

import com.example.demo.Service.NhanVienService;
import com.example.demo.entity.NhanVien;
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
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService service;

    @GetMapping("/find-all")
    public List<NhanVien> getAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    public void addNhanVien(@RequestBody NhanVien nv) {
        service.saveOrUpdate(nv);
    }

    @DeleteMapping("/remove/{id}")
    public void removeNhanVien(@PathVariable String id) {
        service.removeNV(id);
    }

    @GetMapping("/find-by-id/{id}")
    public NhanVien getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/update")
    public void updateNhanVien(@RequestBody NhanVien nv) {
        service.saveOrUpdate(nv);
    }
}
