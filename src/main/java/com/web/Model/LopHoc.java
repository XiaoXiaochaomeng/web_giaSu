package com.web.Model;

import java.util.Date;

public class LopHoc {
    private int id;
    private String usernameHocSinh;
    private String usernameGiaSu;
    private String tenLopHoc;
    private String gioHoc;
    private Date ngayHoc;
    private int hocPhi;
    private int lever;
    private int accept;
    private int phiGiaSu;
    private String moTa;
    private String hinhAnh;

    public LopHoc(int id, String usernameHocSinh, String usernameGiaSu, String tenLopHoc, String gioHoc, Date ngayHoc,
                  int hocPhi, int phiGiaSu, String moTa, String hinhAnh) {
        this.id = id;
        this.usernameHocSinh = usernameHocSinh;
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public LopHoc(int id, String usernameGiaSu, String tenLopHoc, String gioHoc, Date ngayHoc,
                  int hocPhi, int phiGiaSu, String moTa, String hinhAnh) {
        this.id = id;
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public LopHoc(String usernameGiaSu, String tenLopHoc, String gioHoc, Date ngayHoc, int hocPhi, int lever, int accept, int phiGiaSu, String moTa, String hinhAnh) {
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.lever = lever;
        this.accept = accept;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public LopHoc(int id, String usernameHocSinh, String usernameGiaSu, String tenLopHoc, String gioHoc, Date ngayHoc, int hocPhi, int phiGiaSu, String moTa, String hinhAnh ,  int accept, int lever) {
        this.id = id;
        this.usernameHocSinh = usernameHocSinh;
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.lever = lever;
        this.accept = accept;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public LopHoc(String usernameGiaSu, String tenLopHoc, String gioHoc, Date ngayHoc,
                  int hocPhi, int phiGiaSu, String moTa, String hinhAnh,  int accept, int lever) {
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.lever = lever;
        this.accept = accept;
    }

    // Getter và Setter cho các trường

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsernameHocSinh() {
        return usernameHocSinh;
    }

    public void setUsernameHocSinh(String usernameHocSinh) {
        this.usernameHocSinh = usernameHocSinh;
    }

    public String getUsernameGiaSu() {
        return usernameGiaSu;
    }

    public void setUsernameGiaSu(String usernameGiaSu) {
        this.usernameGiaSu = usernameGiaSu;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public String getGioHoc() {
        return gioHoc;
    }

    public void setGioHoc(String gioHoc) {
        this.gioHoc = gioHoc;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getPhiGiaSu() {
        return phiGiaSu;
    }

    public void setPhiGiaSu(int phiGiaSu) {
        this.phiGiaSu = phiGiaSu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
