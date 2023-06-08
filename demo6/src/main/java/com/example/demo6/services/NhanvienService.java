package com.example.demo6.services;

import com.example.demo6.entity.nhanvien;
import com.example.demo6.repository.INhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanvienService {
    @Autowired
    private INhanvienRepository nhanvienRepository;

    public List<nhanvien> getAllNhanvien(){
        return nhanvienRepository.findAll();
    }

    public nhanvien getNhanvienByMa(String ma_nv){
        return nhanvienRepository.findById(ma_nv).orElse(null);
    }

    public void addNhanvien(nhanvien nhanvien){
        nhanvienRepository.save(nhanvien);
    }
    public void updateNhanvien(nhanvien nhanvien){
        nhanvienRepository.save(nhanvien);
    }
    public void deleteNhanvien(String ma_nv){
        nhanvienRepository.deleteById(ma_nv);
    }
}
