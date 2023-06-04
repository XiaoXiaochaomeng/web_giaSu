package com.web.Service;

import com.web.DAO.LopHocDAO;
import com.web.Model.LopHoc;

import java.sql.SQLException;
import java.util.List;

public class LopHocService {
    LopHocDAO lopHocDAO = new LopHocDAO();

    public void insertlopHoc(LopHoc lopHoc) {
        try {
            lopHocDAO.create(lopHoc);
            System.out.println("Thêm học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm học sinh: " + e.getMessage());
        }
    }

    public LopHoc getlopHocById(String idLH) {
        try {
            LopHoc lopHoc = lopHocDAO.getById(Integer.parseInt(idLH));
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

    public List<LopHoc> getlopHocByUsernameGS(String usernameGS) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getLopHocByGS(usernameGS);
            if (lopHocs != null) {
                return lopHocs;
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn Lớp: " + e.getMessage());
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
    public List<LopHoc> getLopHocByLever(int lever, boolean isAdmin) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getLopHocByLever(lever, isAdmin);
            return lopHocs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách học sinh: " + e.getMessage());
        }
        return null;
    }
    public List<LopHoc> getLopHocByGSAndLever(String username,int lever) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getLopHocByGSAndLever(username,lever);
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
    public void acceptLopHoc(int accept, int lopHocId) {
        try {
            lopHocDAO.acceptLopHoc(accept,lopHocId);
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật : " + e.getMessage());
        }
    }


    public int countHocSinhInGS(String giaSuUsername) {
        try {
            return lopHocDAO.countLopHocByGiaSuUsername(giaSuUsername);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void deletelopHoc(String idLH) {
        try {
            lopHocDAO.delete(Integer.parseInt(idLH));
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa Lớp học: " + e.getMessage());
        }
    }
}
