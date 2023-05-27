package com.web.Model;

public class GiaSu {
    private String idGS;
    private String tenGS;
    private String gioitinh;
    private String img;
    private String diachi;
    private String sdt;
    private String email;
    private String stk;
    private MonHoc monHoc;
    private Account account;

    public GiaSu() {
    }

    public GiaSu(String idGS, String tenGS, String gioitinh, String img, String diachi, String sdt, String email, String stk, MonHoc monHoc, Account account) {
        this.idGS = idGS;
        this.tenGS = tenGS;
        this.gioitinh = gioitinh;
        this.img = img;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.stk = stk;
        this.monHoc = monHoc;
        this.account = account;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIdGS() {
        return idGS;
    }

    public void setIdGS(String idGS) {
        this.idGS = idGS;
    }

    public String getTenGS() {
        return tenGS;
    }

    public void setTenGS(String tenGS) {
        this.tenGS = tenGS;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public int countHV;
    public int countLH;

    public int getCountHV() {
        return countHV;
    }

    public void setCountHV(int countHV) {
        this.countHV = countHV;
    }

    public int getCountLH() {
        return countLH;
    }

    public void setCountLH(int countLH) {
        this.countLH = countLH;
    }
}
