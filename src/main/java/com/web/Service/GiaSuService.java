package com.web.Service;

import com.web.DAO.GiaSuDAO;
import com.web.Model.GiaSu;

import java.sql.SQLException;
import java.util.List;

public class GiaSuService {
    GiaSuDAO giaSuDAO = new GiaSuDAO();
    public void insertGiaSu(GiaSu giaSu) {
        try {
            giaSuDAO.insert(giaSu);
            System.out.println("Thêm thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm: " + e.getMessage());
        }
    }

    //Lấy tt của 1 GS theo idGS thông qua giaSuDAO
    public GiaSu getGiaSuById(String idGS) {
        try {
            GiaSu GiaSu = giaSuDAO.getById(idGS);
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

    //Lấy tt GS theo username thông qua giaSuDAO
    public GiaSu getGiaSuByUserName(String username) {
        try {
            GiaSu GiaSu = giaSuDAO.getByUserName(username);
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

    //Lấy ds GS theo lever thông qua đối tượng giaSuDAO
    public List<GiaSu> getGiaSusByLever(int lever) {
        try {
            List<GiaSu> giaSus = giaSuDAO.getAllByLever(lever);
            return giaSus;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách : " + e.getMessage());
        }
        return null;
    }

    public void updateGiaSu(GiaSu GiaSu) {
        try {
            giaSuDAO.update(GiaSu);
            System.out.println("Cập nhật học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật học sinh: " + e.getMessage());
        }
    }

//    public void deleteGiaSu(String idGS) {
//        try {
//            giaSuDAO.(idGS);
//            System.out.println("Xóa học sinh thành công!");
//        } catch (SQLException e) {
//            System.out.println("Lỗi khi xóa học sinh: " + e.getMessage());
//        }
//    }
}
