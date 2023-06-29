package com.example.demo.controller;

import com.example.demo.Service.HoaDonService;
import com.example.demo.entity.HoaDon;
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
@RequestMapping("/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonService service;

    @GetMapping("/find-all")
    public List<HoaDon> getAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    public void addHoaDon(@RequestBody HoaDon hd) {
        service.saveOrUpdate(hd);
    }

    @DeleteMapping("/remove/{id}")
    public void removeHoaDon(@PathVariable String id) {
        service.removeHoaDon(id);
    }

    @GetMapping("/find-by-id/{id}")
    public HoaDon getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/update")
    public void updateHoaDon(@RequestBody HoaDon hd) {
        service.saveOrUpdate(hd);
    }
}
