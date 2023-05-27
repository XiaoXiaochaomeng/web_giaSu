package com.web.Service;

import com.web.DAO.LopHocDAO;
import com.web.Model.LopHoc;

import java.sql.SQLException;
import java.util.List;

public class LopHocService {
    LopHocDAO lopHocDAO = new LopHocDAO();

    public void insertlopHoc(LopHoc lopHoc) {
        try {
            lopHocDAO.insert(lopHoc);
            System.out.println("Thêm lớp học thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm lớp học: " + e.getMessage());
        }
    }

    public LopHoc getlopHocById(String idLH) {
        try {
            LopHoc lopHoc = lopHocDAO.getById(idLH);
            if (lopHoc != null) {
                return lopHoc;
            } else {
                System.out.println("Không tìm thấy học sinh có ID: " + idLH);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn học sinh: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getlopHocByIdGS(String idGS) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getByIdGS(idGS);
            if (lopHocs != null) {
                return lopHocs;
            } else {
                System.out.println("Không tìm thấy học sinh có ID: " + idGS);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn học sinh: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getByUserNameHS(String username) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getByUserNameHS(username);
            if (lopHocs != null) {
                return lopHocs;
            } else {
                System.out.println("Không tìm thấy học sinh có ID: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn học sinh: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getAlllopHocs() {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getAll();
            return lopHocs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách học sinh: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getAlllopHocsByLeverGS(String lever, String idGS) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getByLeverAndGS(lever, idGS);
            return lopHocs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách học sinh: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getAlllopHocsByLeverAdmin(String lever) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getByLeverAdmin(lever);
            return lopHocs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách học sinh: " + e.getMessage());
        }
        return null;
    }

    public void updatelopHoc(LopHoc lopHoc) {
        try {
            lopHocDAO.update(lopHoc);
            System.out.println("Cập nhật học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật học sinh: " + e.getMessage());
        }
    }

    public int countLopByGS(String idLH) {
        try {
            return lopHocDAO.countLopByGS(idLH);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void deletelopHoc(String idHS) {
        try {
            lopHocDAO.delete(idHS);
            System.out.println("Xóa học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa học sinh: " + e.getMessage());
        }
    }
}
