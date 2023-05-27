package com.web.Model;

public class MonHoc {
    private String idMH;
    private String  tenMH;
    private int  lever;
    private String  mota;

    public MonHoc(String idMH, String tenMH, String mota) {
        this.idMH = idMH;
        this.tenMH = tenMH;
        this.mota = mota;
    }

    public MonHoc(String idMH, String tenMH, int lever, String mota) {
        this.idMH = idMH;
        this.tenMH = tenMH;
        this.lever = lever;
        this.mota = mota;
    }


    public MonHoc() {
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }

    public String getIdMH() {
        return idMH;
    }

    public void setIdMH(String idMH) {
        this.idMH = idMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
