package com.web.DAO;

import com.web.Model.MonHoc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonHocDAO extends DBconnect {

    //Thêm môn học
    public void insert(MonHoc monHoc) throws SQLException {
        String query = "INSERT INTO monhoc (idMH, tenMH, mota, lever) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, monHoc.getIdMH());
        statement.setString(2, monHoc.getTenMH());
        statement.setString(3, monHoc.getMota());
        statement.setInt(4, monHoc.getLever());
        statement.executeUpdate();
    }

    //Lấy tt môn học
    public MonHoc getById(String idMH) throws SQLException {
        String query = "SELECT * FROM monhoc WHERE idMH = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idMH);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String tenMH = resultSet.getString("tenMH");
            String mota = resultSet.getString("mota");
            int lever = resultSet.getInt("lever");
            return new MonHoc(idMH, tenMH, lever, mota);
        }
        return null;
    }

    //Lấy tất cả các môn học
    public List<MonHoc> getAll() throws SQLException {
        String query = "SELECT * FROM monhoc";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<MonHoc> monHocs = new ArrayList<>();
        while (resultSet.next()) {
            String idMH = resultSet.getString("idMH");
            String tenMH = resultSet.getString("tenMH");
            String mota = resultSet.getString("mota");
            int lever = resultSet.getInt("lever");

            MonHoc monHoc = new MonHoc(idMH, tenMH,lever, mota);
            monHocs.add(monHoc);
        }
        return monHocs;
    }

    //Cập nhật thông tin môn học
    public void update(MonHoc monHoc) throws SQLException {
        String query = "UPDATE monhoc SET tenMH = ?, mota = ?, lever = ? WHERE idMH = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, monHoc.getTenMH());
        statement.setString(2, monHoc.getMota());
        statement.setInt(3, monHoc.getLever());
        statement.setString(4, monHoc.getIdMH());
        statement.executeUpdate();
    }

    //Xoá môn học
    public void delete(String idMH) throws SQLException {
        String query = "DELETE FROM monhoc WHERE idMH = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, idMH);
        statement.executeUpdate();
    }
}
