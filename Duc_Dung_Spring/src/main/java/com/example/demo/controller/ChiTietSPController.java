package com.example.demo.controller;

import com.example.demo.Service.ChiTietSPService;
import com.example.demo.entity.ChiTietSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chi-tiet-sp")
public class ChiTietSPController {

    @Autowired
    private ChiTietSPService service;

    @GetMapping("/find-all")
    public List<ChiTietSP> findAll() {
        return service.findAll();
    }

    @GetMapping("/find-all/{soTrang}")
    public Page<ChiTietSP> phanTrang(@PathVariable String soTrang) {
        Optional<Integer> integer = Optional.of(Integer.valueOf(soTrang));
        return service.phanTrang(integer);
    }

    @GetMapping("/search/{search}")
    public List<ChiTietSP> searchCTSP(@PathVariable String search) {
        return service.search(search);
    }

    @GetMapping("/find-by-id/{id}")
    public ChiTietSP findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    public void addCtsp(@RequestBody ChiTietSP chiTietSP) {
        service.saveOrUpdate(chiTietSP);
    }

    @DeleteMapping("/remove/{id}")
    public void removeCtsp(@PathVariable String id) {
        service.removeNSX(id);
    }

    @PutMapping("/update")
    public void updateCtsp(@RequestBody ChiTietSP chiTietSP) {
        service.saveOrUpdate(chiTietSP);
    }
}
