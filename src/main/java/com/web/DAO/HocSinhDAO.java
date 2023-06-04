package com.web.DAO;
import com.web.Model.HocSinh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HocSinhDAO extends DBconnect{

    public void create(HocSinh hocSinh) throws SQLException {
        String query = "INSERT INTO HocSinh (ten_hoc_sinh, nam_sinh, sdt, email, so_du_tai_khoan, username, gioi_tinh, dia_chi, so_tai_khoan) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, hocSinh.getTenHocSinh());
            statement.setDate(2, new java.sql.Date(hocSinh.getNamSinh().getTime()));
            statement.setString(3, hocSinh.getSdt());
            statement.setString(4, hocSinh.getEmail());
            statement.setInt(5, hocSinh.getSoDuTaiKhoan());
            statement.setString(6, hocSinh.getUsername());
            statement.setString(7, hocSinh.getGioiTinh());
            statement.setString(8, hocSinh.getDiaChi());
            statement.setString(9, hocSinh.getSoTaiKhoan());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                hocSinh.setId(generatedId);
            }
        }
    }

    public void update(HocSinh hocSinh) throws SQLException {
        String query = "UPDATE HocSinh SET ten_hoc_sinh = ?, nam_sinh = ?, sdt = ?, email = ?, " +
                "so_du_tai_khoan = ?, username = ?, gioi_tinh = ?, dia_chi = ?, so_tai_khoan = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, hocSinh.getTenHocSinh());
            statement.setDate(2, new java.sql.Date(hocSinh.getNamSinh().getTime()));
            statement.setString(3, hocSinh.getSdt());
            statement.setString(4, hocSinh.getEmail());
            statement.setInt(5, hocSinh.getSoDuTaiKhoan());
            statement.setString(6, hocSinh.getUsername());
            statement.setString(7, hocSinh.getGioiTinh());
            statement.setString(8, hocSinh.getDiaChi());
            statement.setString(9, hocSinh.getSoTaiKhoan());
            statement.setInt(10, hocSinh.getId());

            statement.executeUpdate();
        }
    }

    public void delete(int hocSinhId) throws SQLException {
        String query = "DELETE FROM HocSinh WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, hocSinhId);
            statement.executeUpdate();
        }
    }

    public HocSinh getById(int hocSinhId) throws SQLException {
        String query = "SELECT * FROM HocSinh WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, hocSinhId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToHocSinh(resultSet);
                }
            }
        }

        return null;
    }

    public List<HocSinh> getAll() throws SQLException {
        List<HocSinh> hocSinhs = new ArrayList<>();

        String query = "SELECT * FROM HocSinh";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                HocSinh hocSinh = mapResultSetToHocSinh(resultSet);
                hocSinhs.add(hocSinh);
            }
        }

        return hocSinhs;
    }

    private HocSinh mapResultSetToHocSinh(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String tenHocSinh = resultSet.getString("ten_hoc_sinh");
        Date namSinh = resultSet.getDate("nam_sinh");
        String sdt = resultSet.getString("sdt");
        String email = resultSet.getString("email");
        int soDuTaiKhoan = resultSet.getInt("so_du_tai_khoan");
        String username = resultSet.getString("username");
        String gioiTinh = resultSet.getString("gioi_tinh");
        String diaChi = resultSet.getString("dia_chi");
        String soTaiKhoan = resultSet.getString("so_tai_khoan");

        return new HocSinh(id, tenHocSinh, namSinh, sdt, email, soDuTaiKhoan, username, gioiTinh, diaChi, soTaiKhoan);
    }
}