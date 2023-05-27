package com.web.DAO;

import com.web.Model.GiaSu;
import com.web.Model.LopHoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LopHocDAO extends DBconnect{
    GiaSuDAO giaSuDAO= new GiaSuDAO();


    //Thêm lớp học
    public void insert(LopHoc lopHoc) throws SQLException {
        String query = "INSERT INTO lophoc (idLH, tenLH, lichhoc, hocphi, mota, idGS) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, lopHoc.getIdLH());
        statement.setString(2, lopHoc.getTenLH());
        statement.setDate(3, new java.sql.Date(lopHoc.getLichhoc().getTime()));
        statement.setFloat(4, lopHoc.getHocphi());
        statement.setString(5, lopHoc.getMota());
        statement.setString(6, lopHoc.getGiaSu().getIdGS());
        statement.executeUpdate();
    }

    //Lấy tt lớp học theo mã lớp học

    public LopHoc getById(String idLH) throws SQLException {
        String query = "SELECT * FROM lophoc WHERE idLH = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idLH);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String tenLH = resultSet.getString("tenLH");
            Date lichhoc = resultSet.getDate("lichhoc");
            float hocphi = resultSet.getFloat("hocphi");
            String mota = resultSet.getString("mota");
            String idGS = resultSet.getString("idGS");
            GiaSu giaSu = giaSuDAO.getById(idGS); // Assume you have a method to fetch GiaSu object by id
            return new LopHoc(idLH, tenLH, lichhoc, hocphi, mota, giaSu);
        }
        return null;
    }

    //Đếm số lớp học của 1 GS theo idGS
    public int countLopByGS(String idGS) throws SQLException {
        String query = "SELECT count(idLH) as sl FROM web_gia_su.lophoc where idGS = ? group by idGS";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idGS);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("sl");

        }
        return 0;
    }

    //Lấy ds các lớp học của 1 GS dựa trên idGS

    public List<LopHoc> getByIdGS(String idGS) throws SQLException {
        String query = "SELECT * FROM lophoc WHERE idGS = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idGS);
        ResultSet resultSet = statement.executeQuery();
        List<LopHoc> lopHocs = new ArrayList<>();
        while (resultSet.next()) {
            String tenLH = resultSet.getString("tenLH");
            String idLH = resultSet.getString("idLH");
            Date lichhoc = resultSet.getDate("lichhoc");
            float hocphi = resultSet.getFloat("hocphi");
            String mota = resultSet.getString("mota");
            String idGS1 = resultSet.getString("idGS");
            GiaSu giaSu = giaSuDAO.getById(idGS); // Assume you have a method to fetch GiaSu object by id
            LopHoc lopHoc = new LopHoc(idLH, tenLH, lichhoc, hocphi, mota, giaSu);
            lopHocs.add(lopHoc);
        }
        return lopHocs;
    }


    //Lấy ds lớp học dựa trên lever của GS
    public List<LopHoc> getByLeverAdmin(String lever) throws SQLException {
        String query = "SELECT * FROM lophoc WHERE idGS IN (SELECT idGS FROM monhoc join giasu on giasu.idMH = monhoc.idMH WHERE lever = ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, lever);
        ResultSet resultSet = statement.executeQuery();
        List<LopHoc> lopHocs = new ArrayList<>();
        while (resultSet.next()) {
            String tenLH = resultSet.getString("tenLH");
            String idGS = resultSet.getString("idGS");
            String idLH = resultSet.getString("idLH");
            Date lichhoc = resultSet.getDate("lichhoc");
            float hocphi = resultSet.getFloat("hocphi");
            String mota = resultSet.getString("mota");
            GiaSu giaSu = giaSuDAO.getById(idGS);
            LopHoc lopHoc = new LopHoc(idLH, tenLH, lichhoc, hocphi, mota, giaSu);
            lopHocs.add(lopHoc);
        }
        return lopHocs;
    }

    //Lấy ds các lớp học theo lever và idGS
    public List<LopHoc> getByLeverAndGS(String lever, String idGS) throws SQLException {
        String query = "SELECT * FROM lophoc WHERE idGS IN (SELECT idGS FROM monhoc join giasu on giasu.idMH = monhoc.idMH WHERE lever = ? and idGS = ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, lever);
        statement.setString(2, idGS);
        ResultSet resultSet = statement.executeQuery();
        List<LopHoc> lopHocs = new ArrayList<>();
        while (resultSet.next()) {
            String tenLH = resultSet.getString("tenLH");
            String idLH = resultSet.getString("idLH");
            Date lichhoc = resultSet.getDate("lichhoc");
            float hocphi = resultSet.getFloat("hocphi");
            String mota = resultSet.getString("mota");
            GiaSu giaSu = giaSuDAO.getById(idGS);
            LopHoc lopHoc = new LopHoc(idLH, tenLH, lichhoc, hocphi, mota, giaSu);
            lopHocs.add(lopHoc);
        }
        return lopHocs;
    }

    //Lấy ds các LH của 1 hs theo username

    public List<LopHoc> getByUserNameHS(String username) throws SQLException {
        String query = "SELECT lophoc.* FROM web_gia_su.lophoc join dangky on dangky.idLH = lophoc.idLH join hocsinh on hocsinh.idHS = dangky.idHS where username = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        List<LopHoc> lopHocs = new ArrayList<>();
        while (resultSet.next()) {
            String tenLH = resultSet.getString("tenLH");
            String idLH = resultSet.getString("idLH");
            Date lichhoc = resultSet.getDate("lichhoc");
            float hocphi = resultSet.getFloat("hocphi");
            String mota = resultSet.getString("mota");
            String idGS1 = resultSet.getString("idGS");
            GiaSu giaSu = giaSuDAO.getById(idGS1); // Assume you have a method to fetch GiaSu object by id
            LopHoc lopHoc = new LopHoc(idLH, tenLH, lichhoc, hocphi, mota, giaSu);
            lopHocs.add(lopHoc);
        }
        return lopHocs;
    }


    // lấy ds lớp học
    public List<LopHoc> getAll() throws SQLException {
        String query = "SELECT * FROM lophoc";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<LopHoc> lopHocs = new ArrayList<>();
        while (resultSet.next()) {
            String idLH = resultSet.getString("idLH");
            String tenLH = resultSet.getString("tenLH");
            Date lichhoc = resultSet.getDate("lichhoc");
            float hocphi = resultSet.getFloat("hocphi");
            String mota = resultSet.getString("mota");
            String idGS = resultSet.getString("idGS");
            GiaSu giaSu = giaSuDAO.getById(idGS); // Assume you have a method to fetch GiaSu object by id
            LopHoc lopHoc = new LopHoc(idLH, tenLH, lichhoc, hocphi, mota, giaSu);
            lopHocs.add(lopHoc);
        }
        return lopHocs;
    }

    //Cập nhật tt lớp học
    public void update(LopHoc lopHoc) throws SQLException {
        String query = "UPDATE lophoc SET tenLH = ?, lichhoc = ?, hocphi = ?, mota = ?, idGS = ? WHERE idLH = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(6, lopHoc.getIdLH());
        statement.setString(1, lopHoc.getTenLH());
        statement.setDate(2, new java.sql.Date(lopHoc.getLichhoc().getTime()));
        statement.setFloat(3, lopHoc.getHocphi());
        statement.setString(4, lopHoc.getMota());
        statement.setString(5, lopHoc.getGiaSu().getIdGS());
        statement.executeUpdate();
    }

    // Xoá lớp học
    public void delete(String idHS) throws SQLException {
        String query = "DELETE FROM lophoc WHERE idLH = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idHS);
        statement.executeUpdate();
    }
}
