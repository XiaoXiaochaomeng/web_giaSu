package com.web.Controller;

import com.web.Model.GiaSu;
import com.web.Model.LopHoc;
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
        List<LopHoc> list3lv3 = new ArrayList<>();
        List<LopHoc> list4lv3 = new ArrayList<>();
        List<LopHoc> lopHoclv3 = lopHocService.getLopHocByLever(3, false);
        for (int i = 0; i < lopHoclv3.size(); i++) {
            if (i < 3) {
                list3lv3.add(lopHoclv3.get(i));
            } else if (i < 7) {
                list4lv3.add(lopHoclv3.get(i));
            }
        }

        List<LopHoc> list3lv2 = new ArrayList<>();
        List<LopHoc> list4lv2 = new ArrayList<>();
        List<LopHoc> lopHoclv2 = lopHocService.getLopHocByLever(2, false);
        for (int i = 0; i < lopHoclv2.size(); i++) {
            if (i < 3) {
                list3lv2.add(lopHoclv2.get(i));
            } else if (i < 7)
                list4lv2.add(lopHoclv2.get(i));
        }

        List<LopHoc> list3lv1 = new ArrayList<>();
        List<LopHoc> list4lv1 = new ArrayList<>();
        List<LopHoc> lopHoclv1 = lopHocService.getLopHocByLever(1, false);
        for (int i = 0; i < lopHoclv1.size(); i++) {
            if (i < 3) {
                list3lv1.add(lopHoclv1.get(i));
            } else if (i < 7)
                list4lv1.add(lopHoclv1.get(i));
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
