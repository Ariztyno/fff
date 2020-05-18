package com.example.fastfood1.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    public int MaSP;
    public String TenSP;
    public Integer Gia;
    public String Hinh;
    public String MoTa;
    public String TinhTrang;
    public int MaLoai;

    public SanPham(int maSP, String tenSP, Integer gia, String hinh, String moTa, String tinhTrang, int maLoai) {
        MaSP = maSP;
        TenSP = tenSP;
        Gia = gia;
        Hinh = hinh;
        MoTa = moTa;
        TinhTrang = tinhTrang;
        MaLoai = maLoai;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public Integer getGia() {
        return Gia;
    }

    public void setGia(Integer gia) {
        Gia = gia;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }
}
