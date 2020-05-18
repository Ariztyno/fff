package com.example.fastfood1.model;

public class LoaiSP {
    public int MaLoai;
    public String TenLoai;
    public String Hinh;

    public LoaiSP(int maLoai, String tenLoai, String hinh) {
        MaLoai = maLoai;
        TenLoai = tenLoai;
        Hinh = hinh;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String tenLoai) {
        TenLoai = tenLoai;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }
}
