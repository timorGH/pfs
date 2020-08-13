package com.etc.pfs.filter;


import com.etc.pfs.entity.UserInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        UserInfo user = (UserInfo) session.getAttribute("loginUser");
        if(user!=null||url.contains(".js")&&!url.contains(".jsp")|| url.contains("/register")|| url.contains("/validateUsername")  ||url.contains(".css")||url.contains("login.jsp")||url.contains("/verify")||url.contains("/login")||url.contains(".jpg")){
            chain.doFilter(req, resp);
        }else{
            request.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
