
package com.mycompany.javakt.models;

public class NhanVien {
    private long maNV;
    private String tenNV;
    private int mucLuong;
    private long maPB;
    private PhongBan phongBan;

    public NhanVien(long maNV, String tenNV, int mucLuong, PhongBan phongBan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.mucLuong = mucLuong;
        this.phongBan = phongBan;
    }

    public NhanVien(long maNV, String tenNV, int mucLuong, long maPB) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.mucLuong = mucLuong;
        this.maPB = maPB;
    }

    public NhanVien(String tenNV, int mucLuong, long maPB) {
      this.tenNV = tenNV;
      this.mucLuong = mucLuong;
      this.maPB = maPB;
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
    
    public void setMaPB(long maPB) {
      this.maPB = maPB;
    }

    public long getMaPB() {
      return maPB;
    }

    
}
