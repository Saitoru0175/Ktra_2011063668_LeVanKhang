package com.example.demo6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "phongban")
@Entity
public class phongban {
    @Id
    @Column(name = "ma_phong")
    @NotNull(message = "Ma Phong Khong Duoc De Trong")
    @Size(max = 2, message = "Khong Duoc Qua 2 Ky Tu")
    public String ma_phong;

    @Column(name = "ten_phong", length = 30)
    @NotNull(message = "Ten Phong Khong Duoc De Trong")
    @Size(max = 30, message = "Khong Duoc Qua 30 Ky Tu")
    public String ten_phong;

    @OneToMany(mappedBy = "phongban", cascade = CascadeType.ALL)
    public List<nhanvien> nhanviens;
}
