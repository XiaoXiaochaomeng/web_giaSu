package com.web.Model;

import java.util.Date;

public class DangKy {
    private int idDK;
    private Date thoigian;
    private String trangthai;
    private String mota;
    private LopHoc lopHoc;
    private HocSinh hocSinh;

    public DangKy() {
    }

    public DangKy(int idDK, Date thoigian, String trangthai, String mota, LopHoc lopHoc, HocSinh hocSinh) {
        this.idDK = idDK;
        this.thoigian = thoigian;
        this.trangthai = trangthai;
        this.mota = mota;
        this.lopHoc = lopHoc;
        this.hocSinh = hocSinh;
    }

    public int getIdDK() {
        return idDK;
    }

    public void setIdDK(int idDK) {
        this.idDK = idDK;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public LopHoc getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }

    public HocSinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinh hocSinh) {
        this.hocSinh = hocSinh;
    }
}
