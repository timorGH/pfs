package com.etc.pfs.util;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取sql工具类
 */
public class LoadXMLUtil {
    public static Map<String,String> loadMapper(Class clazz){
        String fileName = clazz.getSimpleName();
        Map<String,String> sqlMap = new HashMap<String,String>(16);
        SAXBuilder sb = new SAXBuilder();
        Document doc = null;
        try{
            doc = sb.build(LoadXMLUtil.class.getResourceAsStream("/"+fileName+"Sql.xml"));
        }catch(Exception e){
            e.printStackTrace();
        }
        Element root = doc.getRootElement();
        List<Element> elementList = root.getChildren();
        for (Element e : elementList) {
            sqlMap.put(e.getAttributeValue("id"), e.getText());
        }
        return sqlMap;
    }
}
