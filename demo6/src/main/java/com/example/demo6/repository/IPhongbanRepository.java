package com.example.demo6.repository;

import com.example.demo6.entity.phongban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongbanRepository extends JpaRepository<phongban, String> {
}
