package com.example.demo.Service.impl;

import com.example.demo.Service.GioHangService;
import com.example.demo.entity.GioHang;
import com.example.demo.repository.GioHangRepository;
import com.example.demo.util.ZenMa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository repo;

    private ZenMa zenMa = new ZenMa();

    @Override
    public List<GioHang> findAll() {
        return repo.findAll();
    }

    @Override
    public List<GioHang> checkData() {
        return repo.checkData();
    }

    @Override
    public GioHang findByTinhTrang0() {
        return repo.findByTinhTrang0();
    }

    @Override
    public List<GioHang> findByTinhTrang(Integer tinhTrang) {
        return repo.findByTinhTrang(tinhTrang);
    }

    @Override
    public void themGioHang(GioHang gioHang) {
        gioHang.setMa(zenMa.zenMa("GH", repo.findAll().size() + 1));
        gioHang.setNgayTao(Date.valueOf(LocalDate.now()));
        repo.save(gioHang);
    }

    //thanh toán
    @Override
    public void updateGioHang(GioHang gioHang) {
        //thanh toán
        GioHang idGioHang = findByTinhTrang0();
        idGioHang.setNgayThanhToan(Date.valueOf(LocalDate.now()));
        idGioHang.setTenNguoiNhan(gioHang.getTenNguoiNhan());
        idGioHang.setSdt(gioHang.getSdt());
        idGioHang.setDiaChi(gioHang.getDiaChi());
        idGioHang.setTinhTrang(1);
        System.out.println(idGioHang.toString());
        repo.save(idGioHang);
        //thanh toán xong tạo luôn 1 giỏ hàng mới
        GioHang gioHangNew = new GioHang();
        gioHangNew.setTinhTrang(0);
        themGioHang(gioHangNew);
    }

    @Override
    public void daNhanDuocHang(GioHang gioHang) {
        gioHang.setTinhTrang(3);
        repo.save(gioHang);
    }

    @Override
    public void xacNhan(GioHang gioHang) {
        gioHang.setTinhTrang(2);
        System.out.println(gioHang.toString());
        repo.save(gioHang);
    }

    @Override
    public void removeGioHang(String id) {
        boolean checkData = repo.existsById(id);
        if (checkData == true) {
            repo.deleteById(id);
        }
    }

    @Override
    public GioHang findById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Can not findById " + id));
    }

    @Override
    public GioHang findByMa(String ma) {
        return repo.findByMa(ma);
    }

}
