package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-9-16
 * Time: ����10:11
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesUtils {
    private static Logger log = Logger.getLogger(PropertiesUtils.class);
    private static String fileName = "";
    private static Properties datas = new Properties();

    static {
        try {
            fileName = getClassPath();
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static String getClassPath() {
        String path = PropertiesUtils.class.getResource("").getPath();
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

    public static void loadFile(String name) {
        if (!fileName.contains(name)) {
            fileName = getClassPath() + name;
            if (datas != null)
                datas.clear();
            datas = new Properties();
            if (!fileName.contains(".properties")) {
                fileName += ".properties";
            }
            try {
                FileInputStream in = new FileInputStream(fileName);
                datas.load(in);
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                log.error(e);
            }
        }

    }

    public static Object getValue(String name) {
        return datas.get(name);
    }

    public static boolean setValue(String name, String value) {
        boolean writeOK = true;
        try {
            datas.setProperty(name, value);//��������ֵ���粻���Բ������½�
            FileOutputStream out = new FileOutputStream(fileName);//�����
            datas.store(out, "");//��������ͷ���粻�����ã���Ѻ���һ����""�滻��
            out.flush();//��ջ��棬д�����
            out.close();//�ر������
        } catch (Exception e) {
            log.error(e);
            writeOK = false;
        }
        return writeOK;
    }

    public static Properties getDatas() {
        return datas;
    }
}
