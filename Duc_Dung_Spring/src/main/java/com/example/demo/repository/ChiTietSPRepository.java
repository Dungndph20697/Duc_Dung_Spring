package com.example.demo.repository;

import com.example.demo.entity.ChiTietSP;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, String> {

    @Query("select ctsp from ChiTietSP ctsp where ctsp.sanPham.ten in :name or  ctsp.dongSP.ten in :name or ctsp.mauSac.ten in :name")
    List<ChiTietSP> search(@Param("name") String search);

}
