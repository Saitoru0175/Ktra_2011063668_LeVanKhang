package com.example.demo6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table(name = "nhanvien")
@Entity
public class nhanvien {
    @Id
    @Column(name = "ma_nv")
    @Size(max = 3, message = "Khong Duoc Qua 3 Ky Tu")
    @NotNull(message = "Khong Duoc De Trong")
    public String ma_nv;

    @Column(name = "ten_nv", length = 100)
    @Size(max = 100, message = "Khong Duoc Qua 100 Ky Tu")
    @NotNull(message = "Khong Duoc De Trong")
    public String ten_nv;

    @Column(name = "phai", length = 3)
    @Size(max = 3, message = "Khong Duoc Qua 3 Ky Tu")
    @NotNull(message = "Khong Duoc De Trong")
    public String phai;

    @Column(name = "noi_sinh", length = 200)
    @Size(max = 200, message = "Khong Duoc Qua 200 Ky Tu")
    public String noi_sinh;

    @ManyToOne
    @JoinColumn(name = "phongban_id")
    @NotNull(message = "Khong Duoc De Trong")
    public phongban phongban;

    @Column(name = "luong")
    public int luong;
}
