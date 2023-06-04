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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        String action = req.getParameter("action");
        RequestDispatcher dispatcher = null;
        String idLH = req.getParameter("id");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                dispatcher = req.getRequestDispatcher("/lopHoc/create.jsp");
                break;
            case "edit":
                req.setAttribute("lopHoc", lopHocService.getlopHocById(idLH));
                dispatcher = req.getRequestDispatcher("/lopHoc/edit.jsp");
                break;
            case "delete":
                lopHocService.deletelopHoc(idLH);
                resp.sendRedirect("/managerLopHoc");
                return;
            case "accept":
                lopHocService.acceptLopHoc(1, Integer.parseInt(idLH));
                resp.sendRedirect("/managerLopHoc");
                return;
            case "unAccept":
                lopHocService.acceptLopHoc(0, Integer.parseInt(idLH));
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
            String hour = req.getParameter("hour");
            int lever = Integer.parseInt(req.getParameter("lever"));
            String name = req.getParameter("name");
            String usernameHS = req.getParameter("usernameHS");
            String date = req.getParameter("date");
            String img = req.getParameter("img");
            int price = Integer.parseInt(req.getParameter("price"));
            int priceGS = Integer.parseInt(req.getParameter("priceGS"));
            String content = req.getParameter("content");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LopHoc lopHoc;
            int idLH = 0;
            if (id != null) {
                idLH = Integer.parseInt(id);
                lopHoc = new LopHoc(idLH, usernameHS, account.getUsername(), name, hour, dateFormat.parse(date), price, priceGS, content, img, 0, lever);
            } else {
                lopHoc = new LopHoc(account.getUsername(), name, hour, dateFormat.parse(date), price, priceGS, content, img, 0, lever);
            }


            switch (action) {
                case "create":
                    lopHocService.insertlopHoc(lopHoc);
                    break;
                case "edit":
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
            if (account.getRole().equals("admin")) {
                req.setAttribute("lopHocs", lopHocService.getLopHocByLever(Integer.parseInt(lever), true));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/lopHoc/show.jsp");
                dispatcher.forward(req, resp);
            } else {
                if (account.getRole().equals("gv")) {
                    req.setAttribute("lopHocs", lopHocService.getLopHocByGSAndLever(account.getUsername(), Integer.parseInt(lever)));
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/lopHoc/show.jsp");
                    dispatcher.forward(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
