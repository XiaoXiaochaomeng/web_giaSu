package com.web.DAO;

import com.web.Model.Account;
import com.web.Model.GiaSu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiaSuDAO extends DBconnect {
    AccountDao accountDao = new AccountDao();
    MonHocDAO monHocDAO = new MonHocDAO();

    // Thêm GS
    public void insert(GiaSu giaSu) throws SQLException {
        String query = "INSERT INTO giasu (idGS, tenGS, gioitinh, diachi, sdt, email, stk, idMH, username, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, giaSu.getIdGS());
        statement.setString(2, giaSu.getTenGS());
        statement.setString(3, giaSu.getGioitinh());
        statement.setString(4, giaSu.getDiachi());
        statement.setString(5, giaSu.getSdt());
        statement.setString(6, giaSu.getEmail());
        statement.setString(7, giaSu.getStk());
        statement.setString(8, giaSu.getMonHoc().getIdMH());
        statement.setString(9, giaSu.getAccount().getUsername());
        statement.setString(10, giaSu.getImg());
        statement.executeUpdate();
    }

    //Lấy tt GS theo idGS
    public GiaSu getById(String idGS) throws SQLException {
        String query = "SELECT * FROM giasu WHERE idGS = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idGS);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String tenGS = resultSet.getString("tenGS");
            String gioiTinh = resultSet.getString("gioitinh");
            String img = resultSet.getString("img");
            String diaChi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idMH = resultSet.getString("idMH");
            String username = resultSet.getString("username");
            return new GiaSu(idGS, tenGS, gioiTinh, img, diaChi, sdt, email, stk, monHocDAO.getById(idMH), accountDao.getByUsername(username));
        }
        return null;
    }

    //Lấy tt GS theo username
    public GiaSu getByUserName(String username) throws SQLException {
        String query = "SELECT * FROM giasu WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String tenGS = resultSet.getString("tenGS");
            String gioiTinh = resultSet.getString("gioitinh");
            String img = resultSet.getString("img");
            String diaChi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idMH = resultSet.getString("idMH");
            String idGS = resultSet.getString("idGS");
            return new GiaSu(idGS, tenGS, gioiTinh, img, diaChi, sdt, email, stk, monHocDAO.getById(idMH), accountDao.getByUsername(username));
        }
        return null;
    }

    //Lấy ds tất cả các GS
    public List<GiaSu> getAll() throws SQLException {
        String query = "SELECT * FROM giasu";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<GiaSu> giaSus = new ArrayList<>();
        while (resultSet.next()) {
            String idGS = resultSet.getString("idGS");
            String tenGS = resultSet.getString("tenGS");
            String gioiTinh = resultSet.getString("gioitinh");
            String img = resultSet.getString("img");
            String diaChi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idMH = resultSet.getString("idMH");
            String username = resultSet.getString("username");
            GiaSu giaSu = new GiaSu(idGS, tenGS, gioiTinh, img, diaChi, sdt, email, stk, monHocDAO.getById(idMH), accountDao.getByUsername(username));
            giaSus.add(giaSu);
        }
        return giaSus;
    }

    //Lấy ds các GS theo lever, truy xuất tt từ bảng giasu và monhoc
    public List<GiaSu> getAllByLever(int lever) throws SQLException {
        String query = "SELECT * FROM giasu join monhoc on giasu.idMH = monhoc.idMH where lever = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, lever);

        ResultSet resultSet = statement.executeQuery();
        List<GiaSu> giaSus = new ArrayList<>();
        while (resultSet.next()) {
            String idGS = resultSet.getString("idGS");
            String tenGS = resultSet.getString("tenGS");
            String gioiTinh = resultSet.getString("gioitinh");
            String img = resultSet.getString("img");
            String diaChi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idMH = resultSet.getString("idMH");
            String username = resultSet.getString("username");
            GiaSu giaSu = new GiaSu(idGS, tenGS, gioiTinh, img, diaChi, sdt, email, stk, monHocDAO.getById(idMH), accountDao.getByUsername(username));
            giaSus.add(giaSu);
        }
        return giaSus;
    }

    //Cập nhật tt GS theo idGS
    public void update(GiaSu giaSu) throws SQLException {
        String query = "UPDATE giasu SET tenGS = ?, gioitinh = ? , diachi = ?, sdt = ?, email = ?, stk = ?, idMH = ?, username = ?, ,img = ? WHERE idGS = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(10, giaSu.getIdGS());
        statement.setString(1, giaSu.getTenGS());
        statement.setString(2, giaSu.getGioitinh());
        statement.setString(3, giaSu.getDiachi());
        statement.setString(4, giaSu.getSdt());
        statement.setString(5, giaSu.getEmail());
        statement.setString(6, giaSu.getStk());
        statement.setString(7, giaSu.getMonHoc().getIdMH());
        statement.setString(9, giaSu.getImg());
        statement.setString(8, giaSu.getAccount().getUsername());
        statement.executeUpdate();
    }
}
