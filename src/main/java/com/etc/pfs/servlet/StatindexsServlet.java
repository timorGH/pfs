package com.etc.pfs.servlet;

import com.etc.pfs.entity.PageInfo;
import com.etc.pfs.entity.Remark;
import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.service.AccountsService;
import com.etc.pfs.service.impl.AccountsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/statindexs")
public class StatindexsServlet extends HttpServlet {
    private AccountsService service = new AccountsServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String pageNum = request.getParameter("pageNum");
        String rows = request.getParameter("rows");
        String classif = "生活类";
        UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
        PageInfo<Remark> pageInfo=  service.findAccountsByPage(pageNum,rows,classif,loginUser.getUsername());
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("statindexs.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
