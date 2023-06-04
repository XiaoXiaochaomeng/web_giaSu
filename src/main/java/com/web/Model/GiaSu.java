package com.web.Model;

import java.util.Date;

public class GiaSu {
    private int id;
    private String tenGiaSu;
    private Date namSinh;
    private String sdt;
    private String email;
    private String soTaiKhoan;
    private String username;
    private String gioiTinh;
    private String diaChi;
    private int chuaThanhToan;
    private String hinhAnh;
    private int soDuTaiKhoan;

    public GiaSu(int id, String tenGiaSu, Date namSinh, String sdt, String email, String soTaiKhoan, String username,
                 String gioiTinh, String diaChi, int chuaThanhToan, String hinhAnh, int soDuTaiKhoan) {
        this.id = id;
        this.tenGiaSu = tenGiaSu;
        this.namSinh = namSinh;
        this.sdt = sdt;
        this.email = email;
        this.soTaiKhoan = soTaiKhoan;
        this.username = username;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.chuaThanhToan = chuaThanhToan;
        this.hinhAnh = hinhAnh;
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    // Getter và Setter cho các trường

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenGiaSu() {
        return tenGiaSu;
    }

    public void setTenGiaSu(String tenGiaSu) {
        this.tenGiaSu = tenGiaSu;
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

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
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

    public int getChuaThanhToan() {
        return chuaThanhToan;
    }

    public void setChuaThanhToan(int chuaThanhToan) {
        this.chuaThanhToan = chuaThanhToan;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void setSoDuTaiKhoan(int soDuTaiKhoan) {
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    private int countLH = 0;
    private int countHV = 0;

    public int getCountLH() {
        return countLH;
    }

    public void setCountLH(int countLH) {
        this.countLH = countLH;
    }

    public int getCountHV() {
        return countHV;
    }

    public void setCountHV(int countHV) {
        this.countHV = countHV;
    }
}
