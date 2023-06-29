package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {

//    @Modifying
//    @Query(value = "",nativeQuery = true)
//    List<HoaDon> findByTinhTrangGreaterThanEqual();
}
