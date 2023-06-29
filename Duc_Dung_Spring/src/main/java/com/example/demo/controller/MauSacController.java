package com.example.demo.controller;

import com.example.demo.Service.MauSacService;
import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacService service;

    @GetMapping("/find-all")
    public List<MauSac> getAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    public void addNewMauSac(@RequestBody MauSac ms) {
        service.addMauSac(ms);
    }

    @DeleteMapping("/remove/{id}")
    public void removeMauSac(@PathVariable String id) {
        service.removeMauSac(id);
    }

    @GetMapping("/find-by-id/{id}")
    public MauSac getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/update")
    public void updateMauSac(@RequestBody MauSac ms) {
        service.updateMauSac(ms);
    }

}
