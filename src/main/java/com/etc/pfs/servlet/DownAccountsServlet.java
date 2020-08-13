package com.etc.pfs.servlet;

import com.etc.pfs.entity.Accounts;
import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.service.AccountsService;
import com.etc.pfs.service.impl.AccountsServiceImpl;
import com.etc.pfs.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/downAccounts")
public class DownAccountsServlet extends HttpServlet {
    private AccountsService service = new AccountsServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/ms-excel");
        HttpSession session = request.getSession();
        Integer icategory = Integer.valueOf(request.getParameter("icategory"));
        UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
        String fileName1 = "账目信息_"+System.currentTimeMillis()+".xls";
        String fileName = new String(fileName1.getBytes("utf-8"),"iso-8859-1");
        response.setHeader("Content-Disposition","inline;filename="+fileName);
        ExcelUtil excelUtil = new ExcelUtil();
        String[] title = {"id","收支类型","分类","备注","添加时间","用户名","金额"};
        List<String[]> dateList = new ArrayList<String[]>();
        String icategory1 = "";
        if(icategory==1){
            icategory1="收入";
        }else{
            icategory1="支出";
        }
        List<Accounts> fsList = service.selectAllIcategory(icategory1,userInfo.getUsername());
        for (Accounts as : fsList) {
            String[] dateArr = new String[]{as.getId(),as.getIcategory(),as.getClassif(),as.getRemark(), String.valueOf(as.getAddtime()),as.getUsername(), String.valueOf(as.getMoney())};
            dateList.add(dateArr);
        }
        HSSFWorkbook wb = excelUtil.getHSSFWorkbook(title,dateList);
        ServletOutputStream sos = response.getOutputStream();
        wb.write(sos);
        sos.flush();
        sos.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
