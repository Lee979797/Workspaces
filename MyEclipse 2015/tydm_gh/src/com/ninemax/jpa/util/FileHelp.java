package com.ninemax.jpa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;

import com.jspsmart.upload.SmartUploadException;
import com.ninemax.jpa.global.InitSysParams;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA. User: zhaoxun Date: 13-1-22 Time: ����11:03
 */
public class FileHelp {
    private static Logger log = Logger.getLogger(FileHelp.class);

    public static boolean removeFile(String filePath) throws Exception {
        boolean result = false;
        File dirFile = null;
        try {
            dirFile = new File(filePath);
            File folderFile = dirFile.getAbsoluteFile();
            if (folderFile.exists()) {
                folderFile.delete();
            }
            result = true;
        } catch (Exception e) {
            result = false;
            throw new Exception("ɾ���ļ�����!");
        } finally {
            dirFile = null;
        }
        return result;
    }

    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ�
     *
     * @param sPath ��ɾ��Ŀ¼���ļ�·��
     * @return Ŀ¼ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteDirectory(String sPath) {
        // ���sPath�����ļ��ָ�����β���Զ�����ļ��ָ���
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        // ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        // ɾ���ļ����µ������ļ�(������Ŀ¼)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // ɾ�����ļ�
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            } // ɾ����Ŀ¼
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag)
            return false;
        // ɾ����ǰĿ¼
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * ���Ƶ����ļ�
     *
     * @param oldPath String ԭ�ļ�·�� �磺c:/fqf.txt
     * @param newPath String ���ƺ�·�� �磺f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // �ļ�����ʱ
                InputStream inStream = new FileInputStream(oldPath); // ����ԭ�ļ�
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // �ֽ��� �ļ���С
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            log.error("�����ļ���������", e);
        }

    }

    /**
     * ɾ���ļ���
     *
     * @param folderPath String �ļ���·�������� ��c:/fqf
     *                   String
     * @return boolean
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // ɾ����������������
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); // ɾ�����ļ���

        } catch (Exception e) {
            log.error("ɾ���ļ��в�������", e);
        }

    }

    /**
     * ɾ���ļ�������������ļ�
     *
     * @param path String �ļ���·�� �� c:/fqf
     */
    public static void delAllFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);// ��ɾ���ļ���������ļ�
                delFolder(path + "/" + tempList[i]);// ��ɾ�����ļ���
            }
        }
    }


}
