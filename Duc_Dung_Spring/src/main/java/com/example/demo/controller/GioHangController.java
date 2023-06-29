package com.example.demo.controller;

import com.example.demo.Service.GioHangService;
import com.example.demo.entity.GioHang;
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
@RequestMapping("/gio-hang")
public class GioHangController {
    @Autowired
    private GioHangService service;

    @GetMapping("/find-all")
    public List<GioHang> findAll() {
        return service.findAll();
    }

    @GetMapping("/find-by-tinh-trang-1")
    public List<GioHang> findByTinhTrang1() {
        return service.findByTinhTrang(1);
    }

    @GetMapping("/find-by-tinh-trang-2")
    public List<GioHang> findByTinhTrang2() {
        return service.findByTinhTrang(2);
    }

    @GetMapping("/find-by-id/{id}")
    public GioHang findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    public void addGioHang(@RequestBody GioHang gioHang) {
        service.themGioHang(gioHang);
    }

    @PutMapping("/update")
    public void updateGioHang(@RequestBody GioHang gioHang) {
        service.updateGioHang(gioHang);
    }

    @PutMapping("/da-nhan-duoc-hang")
    public void daNhanDuochang(@RequestBody GioHang gioHang) {
        service.daNhanDuocHang(gioHang);
    }

    @PutMapping("/xac-nhan")
    public void xacNhanGioHang(@RequestBody GioHang gioHang) {
        service.xacNhan(gioHang);
    }

    @DeleteMapping("/remove/{id}")
    public void removeGioHang(@PathVariable String id) {
        service.removeGioHang(id);
    }
}
