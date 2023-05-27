package com.web.Controller;

import com.web.Model.GiaSu;
import com.web.Service.GiaSuService;
import com.web.Service.LopHocService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServelet extends HttpServlet {
    GiaSuService giaSuService = new GiaSuService();
    LopHocService lopHocService = new LopHocService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GiaSu> list3lv3 = new ArrayList<>();
        List<GiaSu> list4lv3 = new ArrayList<>();
        List<GiaSu> giaSuslv3 = giaSuService.getGiaSusByLever(3);
        for (int i = 0; i < giaSuslv3.size(); i++) {
            giaSuslv3.get(i).countLH = lopHocService.countLopByGS(giaSuslv3.get(i).getIdGS());
            if (i < 3) {
                list3lv3.add(giaSuslv3.get(i));
            } else if (i < 7) {
                list4lv3.add(giaSuslv3.get(i));
            }
        }

        List<GiaSu> list3lv2 = new ArrayList<>();
        List<GiaSu> list4lv2 = new ArrayList<>();
        List<GiaSu> giaSuslv2 = giaSuService.getGiaSusByLever(2);
        for (int i = 0; i < giaSuslv2.size(); i++) {
            giaSuslv2.get(i).countLH = lopHocService.countLopByGS(giaSuslv2.get(i).getIdGS());

            if (i < 3) {
                list3lv2.add(giaSuslv2.get(i));
            } else if (i < 7)
                list4lv2.add(giaSuslv2.get(i));
        }

        List<GiaSu> list3lv1 = new ArrayList<>();
        List<GiaSu> list4lv1 = new ArrayList<>();
        List<GiaSu> giaSuslv1 = giaSuService.getGiaSusByLever(1);
        for (int i = 0; i < giaSuslv1.size(); i++) {
            giaSuslv1.get(i).countLH = lopHocService.countLopByGS(giaSuslv1.get(i).getIdGS());

            if (i < 3) {
                list3lv1.add(giaSuslv1.get(i));
            } else if (i < 7)
                list4lv1.add(giaSuslv1.get(i));
        }
        req.setAttribute("list3lv3", list3lv3);
        req.setAttribute("list4lv3", list4lv3);
        req.setAttribute("list3lv2", list3lv2);
        req.setAttribute("list4lv2", list4lv2);
        req.setAttribute("list3lv1", list3lv1);
        req.setAttribute("list4lv1", list4lv1);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
