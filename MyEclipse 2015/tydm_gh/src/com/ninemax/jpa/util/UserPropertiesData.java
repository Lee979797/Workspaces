package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-9-16
 * Time: 上午10:11
 * To change this template use File | Settings | File Templates.
 */
public class UserPropertiesData {
    private static Logger log = Logger.getLogger(UserPropertiesData.class);
    private static String fileName = "";


    static {
        try {
            fileName = getClassPath() + "setUserData.properties";
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static String getClassPath() {
        String path = UserPropertiesData.class.getResource("").getPath();
        int _tempPathIndex = path.indexOf("WEB-INF");
        if (_tempPathIndex != -1) {
            path = path.substring(0, path.indexOf("classes")) + "classes/";
        } else {
            path = System.getProperty("user.dir") + "\\";
        }

        try {
            path = URLDecoder.decode(path, "utf-8");
        } catch (Exception ex) {
        }
        return path;
    }


    public static String getValueByPropertyName(String propertyName) {
        String s = "";
        Properties p = new Properties();//加载属性文件读取类
        FileInputStream in = null;
        try {
            //File f = new File(fileName);
            //System.out.println(f.getAbsolutePath());
            //propertiesFileName如test.properties
            in = new FileInputStream(fileName);//以流的形式读入属性文件
            p.load(in);//属性文件将该流加入的可被读取的属性中
            s = p.getProperty(propertyName);
            //读完了关闭


        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                p.clear();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
        return s;
    }

    public static boolean changeValueByPropertyName(String propertyName, String propertyValue) {
        boolean writeOK = true;
        Properties p = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(fileName);
            p.load(in);//
            in.close();
            p.setProperty(propertyName, propertyValue);//设置属性值，如不属性不存在新建
            FileOutputStream out = new FileOutputStream(fileName);//输出流
            p.store(out, "");//设置属性头，如不想设置，请把后面一个用""替换掉
            out.flush();//清空缓存，写入磁盘
            out.close();//关闭输出流
        } catch (Exception e) {
            log.error(e);
        }
        return writeOK;
    }

}
