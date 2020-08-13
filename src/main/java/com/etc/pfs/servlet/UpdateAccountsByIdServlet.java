package com.etc.pfs.servlet;

import com.etc.pfs.entity.Accounts;
import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.service.AccountsService;
import com.etc.pfs.service.impl.AccountsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/updateAccountsById")
public class UpdateAccountsByIdServlet extends HttpServlet {
    private AccountsService service = new AccountsServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String icategory = request.getParameter("icategory");
        String classif = request.getParameter("subname");
        String remark = request.getParameter("remark");
        Date addtime = new Date();
        UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
        String username = loginUser.getUsername();
        Float money = Float.valueOf(request.getParameter("money"));
        Accounts accounts = new Accounts(id,icategory,classif,remark,addtime,username,money);
        System.out.println(accounts);
        Integer i = service.updateAccounts(accounts);
        if(icategory.equals("收入")){
            if(i>0){
                request.setAttribute("message","修改成功");
                request.getRequestDispatcher("/incomeIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=").forward(request,response);
            }else{
                request.setAttribute("message","修改失败");
                request.getRequestDispatcher("/incomeIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=").forward(request,response);
            }
        }else {
            if(i>0){
                request.setAttribute("message","修改成功");
                request.getRequestDispatcher("/expenditureIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=").forward(request,response);
            }else{
                request.setAttribute("message","修改失败");
                request.getRequestDispatcher("/expenditureIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=").forward(request,response);
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
