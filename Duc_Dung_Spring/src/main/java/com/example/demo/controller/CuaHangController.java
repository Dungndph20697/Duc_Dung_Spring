package com.example.demo.controller;

import com.example.demo.Service.CuaHangService;
import com.example.demo.entity.CuaHang;
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
@RequestMapping("/cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangService service;

    @GetMapping("/find-all")
    public List<CuaHang> findAll() {
        return service.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public CuaHang findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    public void addCuaHang(@RequestBody CuaHang ch) {
        service.saveOrUpdate(ch);
    }

    @PutMapping("/update")
    public void updateCuaHang(@RequestBody CuaHang ch) {
        service.saveOrUpdate(ch);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteCuaHang(@PathVariable String id) {
        service.removeCuaHang(id);
    }

}
