package com.example.demo.controller;

import com.example.demo.Service.NsxService;
import com.example.demo.entity.NSX;
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
@RequestMapping("/nsx")
public class NsxController {
    @Autowired
    private NsxService service;

    @GetMapping("/find-all")
    public List<NSX> findAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    public void addNSX(@RequestBody NSX nsx) {
        service.saveOrUpdate(nsx);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteNSX(@PathVariable String id) {
        service.removeNSX(id);
    }

    @PutMapping("/update")
    public void updateNSX(@RequestBody NSX nsx) {
        service.saveOrUpdate(nsx);
    }

    @GetMapping("/find-by-id/{id}")
    public NSX findById(@PathVariable String id) {
        return service.findById(id);
    }
}
