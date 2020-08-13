package com.etc.pfs.servlet;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/statisticsIndex")
public class StatisticsIndex extends HttpServlet {
    private AccountsService service = new AccountsServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date d = c.getTime();
        String time = format.format(d);
        String nowTime = format.format(new Date());
        // 总收入
        Float gincome = service.selectSumByIcategory("收入",loginUser.getUsername(),time,nowTime);
        // 总支出
        Float texpenditure = service.selectSumByIcategory("支出",loginUser.getUsername(),time,nowTime);
        // 收支情况
        Float iesituation = gincome-texpenditure;
        request.setAttribute("gincome",gincome);
        request.setAttribute("texpenditure",texpenditure);
        request.setAttribute("iesituation",iesituation);
        request.getRequestDispatcher("/statisticsIndex.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
