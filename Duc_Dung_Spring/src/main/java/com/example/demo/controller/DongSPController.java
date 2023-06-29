package com.example.demo.controller;

import com.example.demo.Service.DongSPService;
import com.example.demo.entity.DongSP;
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
@RequestMapping("/dong-sp")
public class DongSPController {
    @Autowired
    private DongSPService service;

    @GetMapping("/find-all")
    public List<DongSP> findAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    public void addDongSP(@RequestBody DongSP dongSP) {
        service.saveOrUpdate(dongSP);
    }

    @GetMapping("/find-by-id/{id}")
    public DongSP findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/remove/{id}")
    public void removeDongSP(@PathVariable String id) {
        service.removeNSX(id);
    }

    @PutMapping("/update")
    public void updateDongSP(@RequestBody DongSP dongSP) {
        service.saveOrUpdate(dongSP);
    }
}
