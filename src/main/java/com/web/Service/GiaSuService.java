package com.web.Service;

import com.web.DAO.GiaSuDAO;
import com.web.Model.GiaSu;

import java.sql.SQLException;
import java.util.List;

public class GiaSuService {
    GiaSuDAO giaSuDAO = new GiaSuDAO();
    public void insertGiaSu(GiaSu giaSu) {
        try {
            giaSuDAO.create(giaSu);
            System.out.println("Thêm thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm: " + e.getMessage());
        }
    }

    public GiaSu getGiaSuById(String idGS) {
        try {
            GiaSu GiaSu = giaSuDAO.getById(Integer.parseInt(idGS));
            if (GiaSu != null) {
                return GiaSu;
            } else {
                System.out.println("Không tìm thấy GS có ID: " + idGS);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn: " + e.getMessage());
        }
        return null;
    }

    public GiaSu getGiaSuByUserName(String username) {
        try {
            GiaSu GiaSu = giaSuDAO.getGiaSuByUsername(username);
            if (GiaSu != null) {
                return GiaSu;
            } else {
                System.out.println("Không tìm thấy GS có ID: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn: " + e.getMessage());
        }
        return null;
    }


    public List<GiaSu> getAllGiaSus() {
        try {
            List<GiaSu> giaSus = giaSuDAO.getAll();
            return giaSus;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách : " + e.getMessage());
        }
        return null;
    }

    public int countHocSinhByGiaSuUsername(String username) {
        try {
            return giaSuDAO.countHocSinhByGiaSuUsername(username);
        } catch (SQLException e) {
            return 0;
        }
    }
    public void updateGiaSu(GiaSu GiaSu) {
        try {
            giaSuDAO.update(GiaSu);
            System.out.println("Cập nhật học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật học sinh: " + e.getMessage());
        }
    }

    public void deleteGiaSu(String idGS) {
        try {
            giaSuDAO.delete(Integer.parseInt(idGS));
            System.out.println("Xóa GS thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa GS: " + e.getMessage());
        }
    }


}
