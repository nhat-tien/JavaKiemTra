
package com.mycompany.javakt.models;

public class NhanVien {
    private long maNV;
    private String tenNV;
    private int mucLuong;
    private PhongBan phongBan;

    public NhanVien(long maNV, String tenNV, int mucLuong, PhongBan phongBan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.mucLuong = mucLuong;
        this.phongBan = phongBan;
    }

    public long getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public int getMucLuong() {
        return mucLuong;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setMaNV(long maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setMucLuong(int mucLuong) {
        this.mucLuong = mucLuong;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }
    
    
}