package com.web.Controller;

import com.web.DAO.AccountDao;
import com.web.Model.Account;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SignUp
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mess = request.getParameter("mess");
        if (mess.equals("rePass")){
            mess = "Nhập Lại Mật Khẩu Sai!";
            request.setAttribute("mess", mess);
        } else if (mess.equals("username")){
            mess = "UserName đã có ngươ sử dụng!";
            request.setAttribute("mess", mess);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String mess ="";
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String repass = request.getParameter("rePass");
            if (!pass.equals(repass)) {
                response.sendRedirect("/register?mess=rePass");
            } else {
                AccountDao accountDao = new AccountDao();
                Account a = accountDao.getAccountByUsername(user);
                if (a != null) {
                    response.sendRedirect("/register?mess=username");
                } else {
                    Account account = new Account(user, pass, "hv");
                    accountDao.createAccount(account);
                    response.sendRedirect("/login");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
