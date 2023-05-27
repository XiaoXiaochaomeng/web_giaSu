package com.web.DAO;

import com.web.Model.DangKy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DangKyDAO extends DBconnect {

    public void insert(DangKy dangKy) throws SQLException {
        String query = "INSERT INTO dangky (idDK, thoigian, trangthai, mota, idLH, idHS) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, dangKy.getIdDK());
        statement.setDate(2, new java.sql.Date(dangKy.getThoigian().getTime()));
        statement.setString(3, dangKy.getTrangthai());
        statement.setString(4, dangKy.getMota());
        statement.setString(5, dangKy.getLopHoc().getIdLH());
        statement.setString(6, dangKy.getHocSinh().getIdHS());
        statement.executeUpdate();
    }

    public DangKy getById(int idDK) throws SQLException {
        LopHocDAO lopHocDAO = new LopHocDAO();
        HocSinhDAO hocSinhDAO = new HocSinhDAO();
        String query = "SELECT * FROM dangky WHERE idDK = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idDK);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String idLH = resultSet.getString("idLH");
            String idHS = resultSet.getString("idHS");
            Date date = resultSet.getDate("thoigian");
            String trangthai = resultSet.getString("trangthai");
            String mota = resultSet.getString("mota");
            return new DangKy(idDK, date, trangthai, mota, lopHocDAO.getById(idLH), hocSinhDAO.getById(idHS));
        }
        return null;
    }
    public DangKy checkDangKy(String idLH, String idHS) throws SQLException {
        LopHocDAO lopHocDAO = new LopHocDAO();
        HocSinhDAO hocSinhDAO = new HocSinhDAO();
        String query = "SELECT * FROM dangky WHERE idLH = ? and idHS = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idLH);
        statement.setString(2, idHS);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int idDK = resultSet.getInt("idDK");
            Date date = resultSet.getDate("thoigian");
            String trangthai = resultSet.getString("trangthai");
            String mota = resultSet.getString("mota");
            return new DangKy(idDK, date, trangthai, mota, lopHocDAO.getById(idLH), hocSinhDAO.getById(idHS));
        }
        return null;
    }

    public List<DangKy> getAll() throws SQLException {
        LopHocDAO lopHocDAO = new LopHocDAO();
        HocSinhDAO hocSinhDAO = new HocSinhDAO();
        String query = "SELECT * FROM dangky";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<DangKy> dangKys = new ArrayList<>();
        while (resultSet.next()) {
            int idDK = resultSet.getInt("idDK");
            String idLH = resultSet.getString("idLH");
            String idHS = resultSet.getString("idHS");
            Date date = resultSet.getDate("thoigian");
            String trangthai = resultSet.getString("trangthai");
            String mota = resultSet.getString("mota");
            DangKy dangKy =  new DangKy(idDK, date, trangthai, mota, lopHocDAO.getById(idLH), hocSinhDAO.getById(idHS));
            dangKys.add(dangKy);
        }
        return dangKys;
    }

    public void update(DangKy dangKy) throws SQLException {
        String query = "UPDATE dangky SET thoigian = ?, trangthai = ?, mota = ?, idLH = ?, idHS = ? WHERE idDK = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDate(1, new java.sql.Date(dangKy.getThoigian().getTime()));
        statement.setString(2, dangKy.getTrangthai());
        statement.setString(3, dangKy.getMota());
        statement.setString(4, dangKy.getLopHoc().getIdLH());
        statement.setString(5, dangKy.getHocSinh().getIdHS());
        statement.setInt(6, dangKy.getIdDK());
        statement.executeUpdate();
    }


    public void delete(int idDK) throws SQLException {
        String query = "DELETE FROM dangky WHERE idDK = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idDK);
        statement.executeUpdate();
    }
}

