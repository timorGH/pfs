package com.etc.pfs.servlet;

import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.service.UserInfoService;
import com.etc.pfs.service.impl.UserInfoServiceImpl;
import com.etc.pfs.util.CommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
    private UserInfoService service = new UserInfoServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Part file = request.getPart("file");
        String id = CommonUtil.getUUID();
        String path = "D:/javaServlet/javaweb/pfs/src/main/webapp/img";
        String ext = file.getSubmittedFileName().split("\\.")[1];
        String fileName = id+"."+ext;
        // 物理保存
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        file.write(path+"/"+fileName);

        // 逻辑保存
        String username = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String telphone = request.getParameter("cell");
        String fileurl = "img/"+fileName;
        UserInfo userInfo = new UserInfo(id,username,pwd,email,telphone,fileurl);
        Integer i = service.inseratUserInfo(userInfo);
        if(i>0){
            request.setAttribute("message","注册成功");
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+"/login.jsp");
            dispatcher.forward(request,response);
        }else{
            request.setAttribute("message","注册失败");
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+"/login.jsp");
            dispatcher.forward(request,response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
