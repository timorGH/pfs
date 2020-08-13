package com.etc.pfs.servlet;

import cn.hutool.captcha.ShearCaptcha;
import com.etc.pfs.dao.UserInfoDao;
import com.etc.pfs.entity.SubJect;
import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.service.SubJectService;
import com.etc.pfs.service.UserInfoService;
import com.etc.pfs.service.impl.SubJectServiceImpl;
import com.etc.pfs.service.impl.UserInfoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    private SubJectService subJectService = new SubJectServiceImpl();
    private UserInfoService userInfoService = new UserInfoServiceImpl();
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        List<SubJect> subjectList = subJectService.selectAllSubject();

        String verify = request.getParameter("yzm");
        ShearCaptcha captcha = (ShearCaptcha) session.getAttribute("captcha");
        boolean isOk = captcha.verify(verify);
        if(isOk){
            String username = request.getParameter("name");
            String password = request.getParameter("pwd");
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            UserInfo loginUser = userInfoService.loginUserInfo(userInfo);
            if(loginUser != null){
                session.setAttribute("subjectList",subjectList);
                session.setAttribute("loginUser",loginUser);
                RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+"/index.jsp");
                dispatcher.forward(request,response);
            }else{
                session.setAttribute("message","用户名或密码错误");
                response.sendRedirect("/login.jsp");
            }
        }else{
            session.setAttribute("message","验证码错误");
            response.sendRedirect("/login.jsp");
        }
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }


}
