package com.example.demo.controller;

import com.example.demo.Service.KhachHangService;
import com.example.demo.entity.KhachHang;
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
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService service;

    @GetMapping("/find-all")
    public List<KhachHang> findAll(){
        return service.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public KhachHang findById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping("/add")
    public void addKhachHang(@RequestBody KhachHang kh){
        service.saveOrUpdate(kh);
    }

    @PutMapping("/update")
    public void updateKhachHang(@RequestBody KhachHang kh){
        service.saveOrUpdate(kh);
    }

    @DeleteMapping("/remove/{id}")
    public void updateKhachHang(@PathVariable String id){
        service.removeKH(id);
    }
}
