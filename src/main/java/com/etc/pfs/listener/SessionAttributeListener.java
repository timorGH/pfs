package com.etc.pfs.listener;

import com.etc.pfs.entity.UserInfo;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {
    private Map<String, HttpSession> sessionMap = new HashMap<String,HttpSession>(16);
    /**
     * 单态登录
     * @param se
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // 如果有登录 就有一个session被添加
        String name = se.getName(); // 是被添加的key
        if("loginUser".equals(name)){
            Object obj = se.getValue();
            UserInfo user = (UserInfo)obj;
            if(sessionMap.containsKey(user.getUsername())){
                sessionMap.get(user.getUsername()).invalidate();
            }
            sessionMap.put(user.getUsername(), se.getSession());
        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
