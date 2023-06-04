package com.web.Controller;

import com.web.Service.LopHocService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/showAllLop")
public class ShowAllLopByLever extends HttpServlet {
    LopHocService lopHocService = new LopHocService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("lopHocs", lopHocService.getAlllopHocs());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/ShowLopHoc.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
