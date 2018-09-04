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
 * Time: ����10:11
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
        Properties p = new Properties();//���������ļ���ȡ��
        FileInputStream in = null;
        try {
            //File f = new File(fileName);
            //System.out.println(f.getAbsolutePath());
            //propertiesFileName��test.properties
            in = new FileInputStream(fileName);//��������ʽ���������ļ�
            p.load(in);//�����ļ�����������Ŀɱ���ȡ��������
            s = p.getProperty(propertyName);
            //�����˹ر�


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
            p.setProperty(propertyName, propertyValue);//��������ֵ���粻���Բ������½�
            FileOutputStream out = new FileOutputStream(fileName);//�����
            p.store(out, "");//��������ͷ���粻�����ã���Ѻ���һ����""�滻��
            out.flush();//��ջ��棬д�����
            out.close();//�ر������
        } catch (Exception e) {
            log.error(e);
        }
        return writeOK;
    }

}
