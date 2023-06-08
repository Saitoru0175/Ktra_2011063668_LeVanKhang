package com.example.demo6.repository;

import com.example.demo6.entity.nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanvienRepository extends JpaRepository<nhanvien, String> {
}
