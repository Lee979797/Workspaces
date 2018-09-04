package com.ninemax.jpa.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Gavin.lee
 * @descripte ��������˼򵥵�BASE64��/���ܷ�����
 * ��Լ������:��ǰʱ�������:�û������ļ�/����
 * Ҳ��ͨ��˫�����������Ӽ��
 */
public class LinkEncrypt {
    private static Logger log = Logger.getLogger(FileHelp.class);

    /**
     * �����ܲ������н���,������
     *
     * @param loginName ���ܵĲ���
     */
    public String[] unPar(String loginName) {
        if (loginName == null || loginName.trim().equals(""))
            return null;
        try {
            String str = decrypt(loginName);
            if (str == null || str.trim().equals("")) {
                return null;
            }
            return str.split(":");
        } catch (Exception e) {
            log.error("LinkEncrypt unPar method IOExcepiton", e);
        }
        return null;
    }

    /**
     * ���ɼ��ܺ�Ĵ��ݲ����ַ���
     *
     * @param secret   ˫��Э������������
     * @param userName �û���
     * @return ���� [˫��Э������������]+[:]+[ϵͳʱ��]+[:]+[�û���]
     */
    public String createPar(String secret, String userName) {
        if (secret == null || secret.trim().equals(""))
            return "";
        if (userName == null || userName.trim().equals(""))
            return "";
        String time = String.valueOf(System.currentTimeMillis() / 1000);
// time ��ʱ����������Դ� 1970.1.1 00:00:00 �����ڵ�����
        StringBuffer sb = new StringBuffer();
        sb.append(secret).append(":");
        sb.append(time).append(":");
        sb.append(userName);
        String loginName = encrypt(sb.toString());
        return loginName;
    }

    /**
     * ���ַ�������BASE64����
     */
    public static String encrypt(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(str.getBytes());
    }

    /**
     * ��BASE64���ܺ���ַ������н���
     */
    public static String decrypt(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(str);
            return new String(b);
        } catch (IOException e) {
            log.error(e);
        }
        return "";
    }
}
