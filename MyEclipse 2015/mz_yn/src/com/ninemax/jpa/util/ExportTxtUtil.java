package com.ninemax.jpa.util;

import com.ninemax.jpa.global.InitSysParams;
import org.apache.log4j.Logger;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-9-4
 * Time: 下午5:24
 */
public class ExportTxtUtil {
    private static Logger log = Logger.getLogger(ExportTxtUtil.class);
    private static Map<String, String> attrMap;

    static {
        attrMap = new HashMap<String, String>();
        attrMap.put("betweenProperty", "\t\t");
        attrMap.put("betweenRecord", "\r\n");
    }

    private static List<String> properties;
    private static String[] title;

    public static List<String> getProperties() {
        if (properties == null)
            return new ArrayList<String>();
        return properties;
    }

    public static void setProperties(List<String> properties) {
        ExportTxtUtil.properties = properties;
    }

    public static String[] getTitle() {
        return title;
    }

    public static void setTitle(String[] title) {
        ExportTxtUtil.title = title;
    }

    public static void transferModelToTxt(File file, List<Object> list) {
        // 获取属性间的分隔符
        String betweenPropery = (String) attrMap.get("betweenProperty");
        // 获取记录间的分隔符
        String betweenRecord = attrMap.get("betweenRecord").toString();
        BufferedOutputStream buff = null;
        FileOutputStream outSTr = null;
        try {
            outSTr = new FileOutputStream(file);
            buff = new BufferedOutputStream(outSTr);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < title.length; i++) {
                if (i == title.length - 1) {
                    sb.append(title[i] + betweenRecord);
                } else {
                    sb.append(title[i] + betweenPropery);
                }
            }
            for (Object obj : list) {
                Class<?> clz = obj.getClass();
                Field[] fields = clz.getDeclaredFields();
                if (properties != null && properties.size() > 0) {
                    for (String property : properties) {
                        for (int i = 0; i < fields.length; i++) {
                            Field field = fields[i];
                            String fieldName = field.getName();
                            boolean dateFlag = false;
                            if (property.equals(fieldName)) {
                                // 把属性名的第一个字母变成大写
                                String firstLetter = fieldName.substring(0, 1)
                                        .toUpperCase();
                                String getMethodName = "get" + firstLetter
                                        + fieldName.substring(1);
                                // 获得和属性对应的getXXX()方法
                                Method getMethod = clz.getMethod(getMethodName,
                                        new Class[]{});
                                // 调用原对象的getXXX()方法
                                Object value = getMethod.invoke(obj,
                                        new Object[]{});
                                if (value instanceof Date) {
                                    String val = DateUtil.dateToStr((Date) value, "yyyy-MM-dd");
                                    sb.append(val + betweenPropery);
                                    dateFlag = true;
                                }
                                // 把为null的用""代替
                                if (value == null) {
                                    value = "";
                                }
                                if("type".equals(property)){
                                    value = InitSysParams.operTypeAllMap.get(value.toString().trim());
                                }
                                if (properties.size() == i && !dateFlag ) {
                                    sb.append(value);
                                } else if(!dateFlag){
                                    sb.append(value + betweenPropery);
                                }
                                break;
                            }
                        }
                    }
                }
                sb.substring(0, sb.length() - 2);
                sb.append(betweenRecord);

            }
            buff.write(sb.toString().getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
}
