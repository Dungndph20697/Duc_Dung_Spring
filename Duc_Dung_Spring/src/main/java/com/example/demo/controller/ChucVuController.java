package com.example.demo.controller;

import com.example.demo.Service.ChucVuService;
import com.example.demo.entity.ChucVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuService service;

    @GetMapping("/find-all")
    public List<ChucVu> findAll() {
        return service.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public ChucVu findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    public void addChucVu(@RequestBody ChucVu chucVu) {
        service.saveOrUpdate(chucVu);
    }

    @PutMapping("/update")
    public void updateChucVu(@RequestBody ChucVu chucVu) {
        service.saveOrUpdate(chucVu);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteChucVu(@PathVariable String id) {
        service.removeChucVu(id);
    }
}
