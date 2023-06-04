package com.web.Controller;

import com.web.Model.LopHoc;
import com.web.Service.LopHocService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/profileLH")

public class ProfileLHServlet extends HttpServlet {
    LopHocService lopHocService = new LopHocService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idLH = req.getParameter("id");
        LopHoc lopHoc = lopHocService.getlopHocById(idLH);
        req.setAttribute("lopHoc", lopHoc);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profileLopHoc.jsp");
        dispatcher.forward(req, resp);
    }
}
