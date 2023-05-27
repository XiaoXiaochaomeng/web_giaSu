package com.web.Controller.manager;

import com.web.Model.Account;
import com.web.Model.LopHoc;
import com.web.Service.GiaSuService;
import com.web.Service.LopHocService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/managerLopHoc")
public class ManagerLopHocServlet extends HttpServlet {
    LopHocService lopHocService = new LopHocService();
    GiaSuService giaSuService = new GiaSuService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        String action = req.getParameter("action");
        RequestDispatcher dispatcher = null;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                dispatcher = req.getRequestDispatcher("/lopHoc/create.jsp");
                break;
            case "edit":
                String idL = req.getParameter("id");
                req.setAttribute("lopHoc", lopHocService.getlopHocById(idL));
                dispatcher = req.getRequestDispatcher("/lopHoc/edit.jsp");
                break;
            case "delete":
                String idLH = req.getParameter("id");
                lopHocService.deletelopHoc(idLH);
                resp.sendRedirect("/managerLopHoc");
                return;
            default:
                showLopHoc(req, resp, account);
                return;
        }

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Account account = (Account) session.getAttribute("account");
            String action = req.getParameter("action");
            RequestDispatcher dispatcher = null;
            if (action == null) {
                action = "";
            }
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String date = req.getParameter("date");
            float price = Float.parseFloat(req.getParameter("price"));
            String content = req.getParameter("content");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            LopHoc lopHoc = new LopHoc(id, name, dateFormat.parse(date), price, content, giaSuService.getGiaSuByUserName(account.getUsername()));
            switch (action) {
                case "create":
                    lopHocService.insertlopHoc(lopHoc);
                    break;
                case "edit":
                    LopHoc lopHoc1 = lopHocService.getlopHocById(id);
                    lopHoc.setGiaSu(lopHoc1.getGiaSu());
                    lopHocService.updatelopHoc(lopHoc);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/managerLopHoc");
    }


    public void showLopHoc(HttpServletRequest req, HttpServletResponse resp, Account account) {
        try {

            String lever = req.getParameter("lever");
            if (lever == null) {
                lever = "1";
            }
            req.setAttribute("account", account);
            if (account.getPosition().equals("admin")) {
                req.setAttribute("lopHocs", lopHocService.getAlllopHocsByLeverAdmin(lever));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/lopHoc/show.jsp");
                dispatcher.forward(req, resp);
            } else {
                if (account.getPosition().equals("gv")) {
                    req.setAttribute("lopHocs", lopHocService.getAlllopHocsByLeverGS(lever, giaSuService.getGiaSuByUserName(account.getUsername()).getIdGS()));
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/lopHoc/show.jsp");
                    dispatcher.forward(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
