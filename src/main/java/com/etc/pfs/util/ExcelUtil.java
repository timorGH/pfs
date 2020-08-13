package com.etc.pfs.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;


/**
 * 下载Excel工具类
 */
public class ExcelUtil {
    public HSSFWorkbook getHSSFWorkbook(String[] title, List<String[]> dataList) {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row0 = sheet.createRow(0);
        for (int i = 0;i < title.length;i++) {
            HSSFCell cell = row0.createCell(i);
            cell.setCellValue(title[i]);
        }
        for (int i = 0;i < dataList.size();i++){
            String[] dataArr = dataList.get(i);
            HSSFRow row = sheet.createRow(i+1);
            for (int j = 0;j < title.length;j++){
                HSSFCell cell0 = row.createCell(j);
                cell0.setCellValue(dataArr[j]);
            }
        }
        return wb;
    }
}
