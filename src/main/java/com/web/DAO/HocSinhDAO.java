package com.web.DAO;
import com.web.Model.HocSinh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocSinhDAO extends DBconnect{

    public void insert(HocSinh hocSinh) throws SQLException {
        String query = "INSERT INTO hocsinh (idHS, tenHS, gioitinh, diachi, sdt, email, stk, username) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, hocSinh.getIdHS());
        statement.setString(2, hocSinh.getTenHS());
        statement.setString(3, hocSinh.getGioitinh());
        statement.setString(4, hocSinh.getDiachi());
        statement.setString(5, hocSinh.getSdt());
        statement.setString(6, hocSinh.getEmail());
        statement.setString(7, hocSinh.getStk());
        statement.setString(8, hocSinh.getAccount().getUsername());
        statement.executeUpdate();
    }

    public HocSinh getById(String idHS) throws SQLException {
        AccountDao accountDao = new AccountDao();
        String query = "SELECT * FROM hocsinh WHERE idHS = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idHS);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String tenHS = resultSet.getString("tenHS");
            String gioitinh = resultSet.getString("gioitinh");
            String diachi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String username = resultSet.getString("username");

            return new HocSinh(idHS, tenHS, gioitinh, diachi, sdt, email, stk, accountDao.getByUsername(username));
        }
        return null;
    }

    public HocSinh getByAccount(String username) throws SQLException {
        AccountDao accountDao = new AccountDao();
        String query = "SELECT * FROM hocsinh WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String tenHS = resultSet.getString("tenHS");
            String gioitinh = resultSet.getString("gioitinh");
            String diachi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idHS = resultSet.getString("idHS");

            return new HocSinh(idHS, tenHS, gioitinh, diachi, sdt, email, stk, accountDao.getByUsername(username));
        }
        return null;
    }

    public List<HocSinh> getAll() throws SQLException {
        AccountDao accountDao = new AccountDao();
        String query = "SELECT * FROM hocsinh";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<HocSinh> hocSinhs = new ArrayList<>();
        while (resultSet.next()) {
            String idHS = resultSet.getString("idHS");
            String tenHS = resultSet.getString("tenHS");
            String gioitinh = resultSet.getString("gioitinh");
            String diachi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String username = resultSet.getString("username");
            HocSinh hocSinh = new HocSinh(idHS, tenHS, gioitinh, diachi, sdt, email, stk, accountDao.getByUsername(username));
            hocSinhs.add(hocSinh);
        }
        return hocSinhs;
    }

    public void update(HocSinh hocSinh) throws SQLException {
        String query = "UPDATE hocsinh SET tenHS = ?, gioitinh = ?, diachi = ?, sdt = ?, email = ?, stk = ?, username = ? WHERE idHS = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(8, hocSinh.getIdHS());
        statement.setString(1, hocSinh.getTenHS());
        statement.setString(2, hocSinh.getGioitinh());
        statement.setString(3, hocSinh.getDiachi());
        statement.setString(4, hocSinh.getSdt());
        statement.setString(5, hocSinh.getEmail());
        statement.setString(6, hocSinh.getStk());
        statement.setString(7, hocSinh.getAccount().getUsername());
        statement.executeUpdate();
    }

    public void delete(String idHS) throws SQLException {
        String query = "DELETE FROM hocsinh WHERE idHS = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idHS);
        statement.executeUpdate();
    }
}