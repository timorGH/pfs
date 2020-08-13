package com.etc.pfs.servlet;

import com.etc.pfs.entity.Accounts;
import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.service.AccountsService;
import com.etc.pfs.service.impl.AccountsServiceImpl;
import com.etc.pfs.util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/insertAccountsServlet")
public class InsertAccountsServlet extends HttpServlet {
    private AccountsService service = new AccountsServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String id = CommonUtil.getUUID();
        Integer icategory = Integer.valueOf(request.getParameter("icategory"));
        String icategory1 = "支出";
        String classif = request.getParameter("classif");
        String remark = request.getParameter("remark");
        UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
        String username = loginUser.getUsername();
        Float money = Float.valueOf(request.getParameter("money"));
        if(icategory==1){
            icategory1="收入";
            Accounts accounts = new Accounts(id,icategory1,classif,remark,new Date(),username,money);
            Integer i = service.insertAccounts(accounts);
            if(i>0){
                request.setAttribute("message","新增成功");
                request.getRequestDispatcher("/incomeIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=").forward(request,response);
            }else{
                request.setAttribute("message","新增失败");
                request.getRequestDispatcher("/incomeIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=").forward(request,response);
            }
        }else{
            Accounts accounts = new Accounts(id,icategory1,classif,remark,new Date(),username,money);
            Integer i = service.insertAccounts(accounts);
            if(i>0){
                request.setAttribute("message","新增成功");
                request.getRequestDispatcher("/expenditureIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=").forward(request,response);
            }else{
                request.setAttribute("message","新增失败");
                request.getRequestDispatcher("/expenditureIndex?pageNum=1&rows=5&money=&addtime=&classif=&remark=").forward(request,response);
            }
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
