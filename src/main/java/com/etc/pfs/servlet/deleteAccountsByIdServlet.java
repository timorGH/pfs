package com.etc.pfs.servlet;

import com.etc.pfs.service.AccountsService;
import com.etc.pfs.service.impl.AccountsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAccountsById")
public class deleteAccountsByIdServlet extends HttpServlet {
    private AccountsService service = new AccountsServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        Integer icategory = Integer.valueOf(request.getParameter("icategory"));
        Integer i = service.deleteAccounts(id);
        if(icategory==1){
            if(i>0){
                request.setAttribute("message","删除成功");
                response.sendRedirect("/incomeIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=");
            }else{
                request.setAttribute("message","删除失败");
                response.sendRedirect("/incomeIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=");
            }
        }else{
            if(i>0){
                request.setAttribute("message","删除成功");
                response.sendRedirect("/expenditureIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=");
            }else{
                request.setAttribute("message","删除失败");
                response.sendRedirect("/expenditureIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=");
            }
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
