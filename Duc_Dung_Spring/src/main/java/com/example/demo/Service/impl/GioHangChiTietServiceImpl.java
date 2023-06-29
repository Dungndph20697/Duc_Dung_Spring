package com.example.demo.Service.impl;

import com.example.demo.Service.ChiTietSPService;
import com.example.demo.Service.GioHangChiTietService;
import com.example.demo.Service.GioHangService;
import com.example.demo.entity.ChiTietSP;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.util.ZenMa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {

    @Autowired
    private GioHangChiTietRepository repo;

    @Autowired
    private GioHangService gioHangService;

    @Override
    public List<GioHangChiTiet> findAll() {
        return repo.getAllByTrangThai(0);
    }

    @Override
    public List<GioHangChiTiet> sanPhamDaMua() {
        return repo.sanPhamDaMua();
    }


    @Override
    public List<GioHangChiTiet> findByTinhTrang1() {
        return repo.getAllByTrangThai(1);
    }

    @Override
    public List<GioHangChiTiet> findByTinhTrang() {
        return repo.getTrangThai();
    }

    @Override
    public List<GioHangChiTiet> dangGiao() {
        return repo.getAllByTrangThai(2);
    }

    @Override
    public BigDecimal tinhTongTien() {
        BigDecimal tongTien = BigDecimal.valueOf(0);
        for (GioHangChiTiet ghct : repo.getAllByTrangThai(0)) {
            BigDecimal tienSp = ghct.getDonGia();
            BigDecimal tienRong = BigDecimal.valueOf(0);
            tongTien = tongTien.add(tienSp);
        }
        return tongTien;
    }


    @Override
    public void saveOrUpdate(GioHangChiTiet gioHangChiTiet) {
        GioHang gh = gioHangService.findByTinhTrang0();
        GioHangChiTiet ghctUpdate = repo.checkData(gioHangChiTiet.getChiTietSP().getId(), gh.getId());
        //nếu có sp rồi thì update
        if (ghctUpdate != null) {
            BigDecimal giaGoc = gioHangChiTiet.getDonGia();
            BigDecimal nhan2 = new BigDecimal("2");
            BigDecimal giaSauKhiThem = giaGoc.multiply(nhan2);
            gioHangChiTiet.setId(ghctUpdate.getId());
            gioHangChiTiet.setGioHang(gh);
            gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
            gioHangChiTiet.setDonGia(giaSauKhiThem);
            repo.save(gioHangChiTiet);
        } else {
            //thêm mới
            gioHangChiTiet.setGioHang(gh);
            repo.save(gioHangChiTiet);
        }
    }

    @Override
    public void removeGhct(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public GioHangChiTiet findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }

}
