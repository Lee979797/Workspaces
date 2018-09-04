package com.ninemax.jpa.util;

import com.ninemax.jpa.code.model.Field;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import javax.persistence.EntityManager;
import java.io.*;
import java.util.*;

/**
 * * User: zhhuiyan
 * Date: 13-5-20
 * Time: 上午9:10
 * Name:${Name}
 */
public class ExcelUtils {
    private static WritableSheet createSheet(WritableWorkbook book, String title, int n, List<Field> fields) throws WriteException {
        WritableSheet sheet = book.createSheet(title, (short) n); // sheet名称
        WritableFont font = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD,
                false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
        WritableCellFormat wcfFC = new WritableCellFormat(font);
        wcfFC.setBackground(Colour.AQUA);
        int i = 0;
        for (Field field : fields) {
            if (field != null && field.isSelect()) {
                sheet.addCell(new Label(i, 0, field.getName(), wcfFC));
                i++;

            }

        }
        return sheet;
    }

    public static boolean export(String fileName, String table,String bzjgdm, String sqlwhere, List<Field> fields) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Integer lenth = ((Long) em.createQuery("select count(model)  from " + table + " model  where model.bzjgdm like '"+bzjgdm+"%' and  " + sqlwhere)
                .getResultList().get(0)).intValue();
        try {
            WritableWorkbook book = Workbook.createWorkbook(new File(fileName)); // 建立excel文件
            String title = "机构代码-sheet"; // 标题
            for (int k = 0; k < lenth / 50000 + 1; k++) {
                List list = em.createQuery("select model from " + table + " model  where model.bzjgdm like '"+bzjgdm+"%' and " + sqlwhere)
                        .setFirstResult(k * 50000).setMaxResults(50000)
                        .getResultList();
                WritableSheet sheet = createSheet(book, title + (k > 0 ? k + "" : ""), k, fields);
                for (int l = 0;  l < list.size(); l++) {
                    Map<Object, Object> beans = BeanUtilsEx.describe(list.get(l));
                    int i = 0;
                    for (Field field : fields) {
                    	
                        if (field != null && field.isSelect()) {
                        	Object v =null;
                        	if("机构类型".equals(field.getName())){
                        		if(!"".equals(beans.get(field.getDm()))&&beans.get(field.getDm())!=null){
                        			
                        			v=InitSysParams.jglxMap.get(beans.get(field.getDm()).toString().trim());
                        		}else{
                        			v="";
                        		}
                        	}else if("行政区划".equals(field.getName())){
                        		if(!"".equals(beans.get(field.getDm()))&&beans.get(field.getDm())!=null){
                        			
                        			v=InitSysParams.xzqhMap.get(beans.get(field.getDm()).toString().trim());
                        		}else{
                        			v="";
                        		}
                        	}else if("经济行业(2011版)".equals(field.getName())){
                        		if(!"".equals(beans.get(field.getDm()))&&beans.get(field.getDm())!=null){
                        			
                        			v=InitSysParams.jjhy2k1Map.get(beans.get(field.getDm()).toString().trim());
                        		}else{
                        			v="";
                        		}
                        	}else if("经济类型(2011版)".equals(field.getName())){
                        		if(!"".equals(beans.get(field.getDm()))&&beans.get(field.getDm())!=null){
                        			v=InitSysParams.jjlx2k1Map.get(beans.get(field.getDm()).toString().trim());
                        			
                        		}else{
                        			v="";
                        		}
                        	}else{
                        		
                        		v = beans.get(field.getDm());
                        	}
                            String value = "";
                            if (v != null)
                                value = v.toString();
                            sheet.addCell(new Label(i, 1 + l, value));
                            i++;
                        }
                    }
                }
            }


            book.write();
            book.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean export(String fileName, List<TJgdm> list, List<Field> fields) {
        try {
            WritableWorkbook book = Workbook.createWorkbook(new File(fileName)); // 建立excel文件
            String title = "机构代码-sheet"; // 标题
            Integer lenth = list.size();
            for (int k = 0; k < lenth / 50000 + 1; k++) {
                WritableSheet sheet = createSheet(book, title + (k > 0 ? k + "" : ""), k, fields);
                for (int l = 0, j = 50000 * k; j < 50000 * (k + 1) && j < list.size(); l++, j++) {
                    Map<Object, Object> beans = BeanUtilsEx.describe(list.get(j));
                    int i = 0;
                    for (Field field : fields) {
                        if (field != null && field.isSelect()) {
                            Object v = beans.get(field.getDm());
                            String value = "";
                            if (v != null)
                                value = v.toString();
                            sheet.addCell(new Label(i, 1 + l, value));
                            i++;
                        }
                    }
                }
            }


            book.write();
            book.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
