package com.etc.pfs.test;


import com.etc.pfs.dao.UserInfoDao;
import com.etc.pfs.entity.UserInfo;
import com.etc.pfs.util.CommonUtil;
import com.etc.pfs.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaTest {


    /**
     * jdbc测试类
     */
    @Test
    public void JdbcUtilTest(){
        try {
            System.out.println(JDBCUtils.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 登录测试
     */
    @Test
    public void LoginUserInfoTest(){
        UserInfoDao userInfoDao = new UserInfoDao();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("timor");
        userInfo.setPassword("123456");
        UserInfo user = userInfoDao.loginUserInfo(userInfo);
        if(CommonUtil.isNull(user)){
            System.out.println("null");
        }else{
            System.out.println(user);
        }
    }

    /**
     * 日期测试
     */
    @Test
    public void SimpleDateFormatTest(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date d = c.getTime();
        String day = format.format(d);
        String nowTime = format.format(new Date());
        System.out.println("过去七天："+day);
        System.out.println(nowTime);
    }

}
