package com.web.Model;

public class HocSinh {
    private String idHS;
    private String tenHS;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private String email;
    private String stk;
    private Account account;

    public HocSinh() {
    }

    public HocSinh(String idHS, String tenHS, String gioitinh, String diachi, String sdt, String email, String stk, Account account) {
        this.idHS = idHS;
        this.tenHS = tenHS;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.stk = stk;
        this.account = account;
    }

    public String getIdHS() {
        return idHS;
    }

    public void setIdHS(String idHS) {
        this.idHS = idHS;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
