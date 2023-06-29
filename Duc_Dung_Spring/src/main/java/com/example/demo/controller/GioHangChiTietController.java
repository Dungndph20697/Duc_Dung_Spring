package com.example.demo.controller;

import com.example.demo.Service.GioHangChiTietService;
import com.example.demo.entity.GioHangChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/gio-hang-chi-tiet")
public class GioHangChiTietController {
    @Autowired
    private GioHangChiTietService service;

    @GetMapping("/find-all")
    public List<GioHangChiTiet> findAll() {
        return service.findAll();
    }

    @GetMapping("/san-pham-da-mua")
    public List<GioHangChiTiet> sanPhamDaMua() {
        return service.sanPhamDaMua();
    }

    @GetMapping("/cho-xac-nhan")
    public List<GioHangChiTiet> findByTrangThai1() {
        return service.findByTinhTrang1();
    }

    @GetMapping("/dang-giao")
    public List<GioHangChiTiet> dangGiao() {
        return service.dangGiao();
    }

    @GetMapping("/tinh-trang")
    public List<GioHangChiTiet> findByTrangThai() {
        return service.findByTinhTrang();
    }

    @PostMapping("/add")
    public void addGioHangChiTiet(@RequestBody GioHangChiTiet gioHangChiTiet) {
        service.saveOrUpdate(gioHangChiTiet);
    }

    @DeleteMapping("/remove/{id}")
    public void removeGioHangChiTiet(@PathVariable String id) {
        service.removeGhct(id);
    }

    @GetMapping("/tong-tien")
    public BigDecimal tongTien() {
        return service.tinhTongTien();
    }

}
