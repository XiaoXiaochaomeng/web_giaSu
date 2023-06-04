package com.web.DAO;

import com.web.Model.Account;
import com.web.Model.GiaSu;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GiaSuDAO extends DBconnect {
    public void create(GiaSu giaSu) throws SQLException {
        String query = "INSERT INTO GiaSu (ten_gia_su, nam_sinh, sdt, email, so_tai_khoan, username, gioi_tinh, dia_chi, chua_thanh_toan, hinh_anh, so_du_tai_khoan) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, giaSu.getTenGiaSu());
            statement.setDate(2, new java.sql.Date(giaSu.getNamSinh().getTime()));
            statement.setString(3, giaSu.getSdt());
            statement.setString(4, giaSu.getEmail());
            statement.setString(5, giaSu.getSoTaiKhoan());
            statement.setString(6, giaSu.getUsername());
            statement.setString(7, giaSu.getGioiTinh());
            statement.setString(8, giaSu.getDiaChi());
            statement.setInt(9, giaSu.getChuaThanhToan());
            statement.setString(10, giaSu.getHinhAnh());
            statement.setInt(11, giaSu.getSoDuTaiKhoan());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                giaSu.setId(generatedId);
            }
        }
    }

    public void update(GiaSu giaSu) throws SQLException {
        String query = "UPDATE GiaSu SET ten_gia_su = ?, nam_sinh = ?, sdt = ?, email = ?, so_tai_khoan = ?, " +
                "username = ?, gioi_tinh = ?, dia_chi = ?, chua_thanh_toan = ?, hinh_anh = ?, so_du_tai_khoan = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, giaSu.getTenGiaSu());
            statement.setDate(2, new java.sql.Date(giaSu.getNamSinh().getTime()));
            statement.setString(3, giaSu.getSdt());
            statement.setString(4, giaSu.getEmail());
            statement.setString(5, giaSu.getSoTaiKhoan());
            statement.setString(6, giaSu.getUsername());
            statement.setString(7, giaSu.getGioiTinh());
            statement.setString(8, giaSu.getDiaChi());
            statement.setInt(9, giaSu.getChuaThanhToan());
            statement.setString(10, giaSu.getHinhAnh());
            statement.setInt(11, giaSu.getSoDuTaiKhoan());
            statement.setInt(12, giaSu.getId());

            statement.executeUpdate();
        }
    }

    public void delete(int giaSuId) throws SQLException {
        String query = "DELETE FROM GiaSu WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, giaSuId);
            statement.executeUpdate();
        }
    }

    public GiaSu getById(int giaSuId) throws SQLException {
        String query = "SELECT * FROM GiaSu WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, giaSuId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToGiaSu(resultSet);
                }
            }
        }

        return null;
    }

    public List<GiaSu> getAll() throws SQLException {
        List<GiaSu> giaSus = new ArrayList<>();

        String query = "SELECT * FROM GiaSu";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                GiaSu giaSu = mapResultSetToGiaSu(resultSet);
                giaSus.add(giaSu);
            }
        }

        return giaSus;
    }
    public GiaSu getGiaSuByUsername(String username) throws SQLException {
        String query = "SELECT * FROM GiaSu WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToGiaSu(resultSet);
                }
            }
        }

        return null;
    }

    public int countHocSinhByGiaSuUsername(String giaSuUsername) throws SQLException {
        String query = "SELECT COUNT(*) FROM LopHoc lh LEFT JOIN HocSinh hs ON lh.id = hs.lop_hoc_id WHERE lh.username_gia_su = ? AND (hs.id IS NULL OR hs.id <> 0)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, giaSuUsername);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }

        return 0;
    }

    private GiaSu mapResultSetToGiaSu(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String tenGiaSu = resultSet.getString("ten_gia_su");
        Date namSinh = resultSet.getDate("nam_sinh");
        String sdt = resultSet.getString("sdt");
        String email = resultSet.getString("email");
        String soTaiKhoan = resultSet.getString("so_tai_khoan");
        String username = resultSet.getString("username");
        String gioiTinh = resultSet.getString("gioi_tinh");
        String diaChi = resultSet.getString("dia_chi");
        int chuaThanhToan = resultSet.getInt("chua_thanh_toan");
        String hinhAnh = resultSet.getString("hinh_anh");
        int soDuTaiKhoan = resultSet.getInt("so_du_tai_khoan");

        return new GiaSu(id, tenGiaSu, namSinh, sdt, email, soTaiKhoan, username, gioiTinh, diaChi, chuaThanhToan, hinhAnh, soDuTaiKhoan);
    }

}
