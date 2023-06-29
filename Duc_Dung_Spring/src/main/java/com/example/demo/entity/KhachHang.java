package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GenericGenerator(name = "gennerator",strategy = "guid",parameters = {})
    @GeneratedValue(generator = "gennerator")
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "tendem")
    private String tenDem;

    @Column(name = "ho")
    private String ho;

    @Column(name = "ngaysinh")
    private String ngaySinh;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "thanhpho")
    private String thanhPho;

    @Column(name = "quocgia")
    private String quocGia;

    @Column(name = "matkhau")
    private String matKhau;
}
