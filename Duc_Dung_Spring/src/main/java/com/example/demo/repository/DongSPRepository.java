package com.example.demo.repository;

import com.example.demo.entity.DongSP;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DongSPRepository extends JpaRepository<DongSP, String> {
}
