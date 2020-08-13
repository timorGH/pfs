package com.etc.pfs.servlet;

import com.etc.pfs.entity.Accounts;
import com.etc.pfs.service.AccountsService;
import com.etc.pfs.service.impl.AccountsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getAccountsById")
public class GetAccountsByIdServlet extends HttpServlet {
    private AccountsService service = new AccountsServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        Accounts accounts = service.selectAccountsById(id);
        request.setAttribute("accounts",accounts);
        request.getRequestDispatcher("/modify.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
