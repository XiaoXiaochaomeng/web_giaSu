package com.web.Controller;

import com.web.DAO.DangKyDAO;
import com.web.DAO.HocSinhDAO;
import com.web.Model.Account;
import com.web.Model.DangKy;
import com.web.Model.HocSinh;
import com.web.Model.LopHoc;
import com.web.Service.LopHocService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(urlPatterns = "/dangKy")
public class DangKyServlet extends HttpServlet {
    DangKyDAO dangKyDAO = new DangKyDAO();
    HocSinhDAO hocSinhDAO = new HocSinhDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idLH = req.getParameter("id");
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        LopHoc lopHoc = new LopHoc();
        lopHoc.setIdLH(idLH);
        try {
            HocSinh hocSinh = hocSinhDAO.getByAccount(account.getUsername());
            if (dangKyDAO.checkDangKy(lopHoc.getIdLH(), hocSinh.getIdHS()) == null) {
                DangKy dangKy = new DangKy(0, new Date(), "new", "new", lopHoc, hocSinh);
                dangKyDAO.insert(dangKy);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        resp.sendRedirect("/lopHoc");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
