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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "cuahang")
public class CuaHang {
    @Id
    @GenericGenerator(name = "gennerator",strategy = "guid",parameters = {})
    @GeneratedValue(generator = "gennerator")
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "thanhpho")
    private String thanhPho;

    @Column(name = "quocgia")
    private String quocGia;
}
