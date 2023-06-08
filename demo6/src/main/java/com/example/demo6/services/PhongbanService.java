package com.example.demo6.services;

import com.example.demo6.entity.phongban;
import com.example.demo6.repository.IPhongbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongbanService {
    @Autowired
    private IPhongbanRepository phongbanRepository;

    public List<phongban> getAllPhongban(){return phongbanRepository.findAll();}
    public phongban getPhongbanByMa(String ma_phong){return phongbanRepository.findById(ma_phong).orElse(null);}
    public phongban savePhongban(phongban phongban){return  phongbanRepository.save(phongban);}
    public void deletePhongban(String ma_phong){phongbanRepository.deleteById(ma_phong);}
}
