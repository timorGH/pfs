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

@WebServlet("/updateUserInfoServlet")
@MultipartConfig
public class UpdateUserInfoServlet extends HttpServlet {
    private UserInfoService service = new UserInfoServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        Part file = request.getPart("file");;
        // 获取文件保存路径以及文件信息
        String fid = CommonUtil.getUUID();
        String path = "D:/javaServlet/javaweb/pfs/src/main/webapp/img";
        String ext = file.getSubmittedFileName().split("\\.")[1];
        String fileName = fid+"."+ext;
        // 物理保存
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdir();
        }
        file.write(path+"/"+fileName);
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String telphone = request.getParameter("telphone");
        String email = request.getParameter("email");
        String fileurl = "img/"+fileName;
        UserInfo userInfo = new UserInfo(id,username,password,telphone,email,fileurl);
        Integer i = service.updateUserInfo(userInfo);
        if(i>0){
            request.setAttribute("message","修改成功");
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+"/index.jsp");
            dispatcher.forward(request,response);
        }else{
            request.setAttribute("message","修改失败");
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath()+"/index.jsp");
            dispatcher.forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
