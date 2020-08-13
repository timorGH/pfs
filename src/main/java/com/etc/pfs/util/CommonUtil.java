package com.etc.pfs.util;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * 数据工具类
 */
public class CommonUtil {
    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return obj==null?true:false;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        if(str == null || "".equals(str)){
            return true;
        }
        return false;
    }

    /**
     * 判断List是否为空
     * @param list
     * @return
     */
    public static boolean isNull(List<?> list){
        if(list == null || list.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 获取当前时间 格式：yyyy-MM-dd_HH:mm:ss
     * @return
     */
    public static String getCurrDate(){
        return new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new java.util.Date());
    }


    /**
     * 获取当前时间 格式：自定义
     * @param template
     * @return
     */
    public static String getCurrDate(String template) {
        return new SimpleDateFormat(template).format(new java.util.Date());
    }

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
