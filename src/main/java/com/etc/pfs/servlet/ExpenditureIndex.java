package com.etc.pfs.servlet;

import com.etc.pfs.entity.Accounts;
import com.etc.pfs.entity.PageInfo;
import com.etc.pfs.entity.SubJect;
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
import java.util.List;
import java.util.Map;

@WebServlet("/expenditureIndex")
public class ExpenditureIndex extends HttpServlet {
    private AccountsService service = new AccountsServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String pageNum = request.getParameter("pageNum");
        String rows = request.getParameter("rows");
        Map<String, String[]> condition = request.getParameterMap();
        UserInfo loginUser = (UserInfo)session.getAttribute("loginUser");
        PageInfo<Accounts> pageInfo =  service.selectAllIcategory("支出",loginUser.getUsername(),pageNum,rows,condition);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/expenditureIndex.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
