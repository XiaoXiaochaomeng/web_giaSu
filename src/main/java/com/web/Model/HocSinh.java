package com.web.Model;

import java.util.Date;

public class HocSinh {
    private int id;
    private String tenHocSinh;
    private Date namSinh;
    private String sdt;
    private String email;
    private int soDuTaiKhoan;
    private String username;
    private String gioiTinh;
    private String diaChi;
    private String soTaiKhoan;

    public HocSinh(int id, String tenHocSinh, Date namSinh, String sdt, String email, int soDuTaiKhoan, String username,
                   String gioiTinh, String diaChi, String soTaiKhoan) {
        this.id = id;
        this.tenHocSinh = tenHocSinh;
        this.namSinh = namSinh;
        this.sdt = sdt;
        this.email = email;
        this.soDuTaiKhoan = soDuTaiKhoan;
        this.username = username;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soTaiKhoan = soTaiKhoan;
    }

    // Getter và Setter cho các trường

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void setSoDuTaiKhoan(int soDuTaiKhoan) {
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }
}
