package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "chiTietSP")
public class ChiTietSP {
    @Id
    @GenericGenerator(name = "gennerator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "gennerator")
    @Column(name = "Id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idsp", referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idnsx", referencedColumnName = "Id")
    private NSX nsx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddongsp", referencedColumnName = "Id")
    private DongSP dongSP;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idmausac", referencedColumnName = "Id")
    private MauSac mauSac;

    @Column(name = "nambh")
    private Integer namBH;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "soluongton")
    private Integer soLuongTon;

    @Column(name = "gianhap")
    private BigDecimal giaNhap;

    @Column(name = "giaban")
    private BigDecimal giaBan;

    @Column(name = "Anh")
    private String anh;
}
