package com.web.Service;

import com.web.DAO.HocSinhDAO;
import com.web.Model.HocSinh;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HocSinhService {
    private HocSinhDAO hocSinhDAO = new HocSinhDAO();


    public void insertHocSinh(HocSinh hocSinh) {
        try {
            hocSinhDAO.insert(hocSinh);
            System.out.println("Thêm học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm học sinh: " + e.getMessage());
        }
    }

    public HocSinh getHocSinhById(String idHS) {
        try {
            HocSinh hocSinh = hocSinhDAO.getById(idHS);
            if (hocSinh != null) {
                return hocSinh;
            } else {
                System.out.println("Không tìm thấy học sinh có ID: " + idHS);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn học sinh: " + e.getMessage());
        }
        return null;
    }

    public List<HocSinh> getAllHocSinhs() {
        try {
            List<HocSinh> hocSinhs = hocSinhDAO.getAll();
            return hocSinhs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách học sinh: " + e.getMessage());
        }
        return null;
    }

    public void updateHocSinh(HocSinh hocSinh) {
        try {
            hocSinhDAO.update(hocSinh);
            System.out.println("Cập nhật học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật học sinh: " + e.getMessage());
        }
    }

    public void deleteHocSinh(String idHS) {
        try {
            hocSinhDAO.delete(idHS);
            System.out.println("Xóa học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa học sinh: " + e.getMessage());
        }
    }
}

