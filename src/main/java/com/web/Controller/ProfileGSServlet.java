package com.web.Controller;

import com.web.DAO.GiaSuDAO;
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
import java.util.List;

@WebServlet(urlPatterns = "/profileGS")
public class ProfileGSServlet extends HttpServlet {
    GiaSuService giaSuService = new GiaSuService();
    LopHocService lopHocService = new LopHocService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idGS = req.getParameter("id");
        GiaSu giaSu = giaSuService.getGiaSuById(idGS);
        List<LopHoc> lopHocs = lopHocService.getlopHocByIdGS(giaSu.getIdGS());

        req.setAttribute("giaSu", giaSu);
        req.setAttribute("lopHocs", lopHocs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profileGiaSu.jsp");
        dispatcher.forward(req, resp);

    }
}
