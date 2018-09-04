package com.ninemax.jpa.util;

import java.security.MessageDigest;

public class MD532 {
    //	ʮ�����������ֵ��ַ���ӳ������
    private final static String[] hexDigits = {"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d",
            "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m",
            "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C"
            , "V", "N", "M", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "[", "]", "{", "}"
            , "\\", "|", ";", ":", "\"", "'", "<", ">", ",", ".", "?", "/", " "
    };

    public static String createPassword(String inputString) {
        return encodeByMD5(inputString);
    }


    public static boolean authenticatePassword(String password, String inputString) {
        return password.equals(encodeByMD5(inputString));
    }


    private static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                //��������ָ���㷨���Ƶ���ϢժҪ
                MessageDigest md = MessageDigest.getInstance("MD5");
                //ʹ��ָ�����ֽ������ժҪ���������£�Ȼ�����ժҪ����
                byte[] results = md.digest(originString.getBytes());
                //���õ����ֽ��������ַ�������
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }


    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(byteToHexString(b));
        }
        return result.toString();
    }


    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
    //public static void writeDataBase(DataBasic data,String md){

    // }
    public static void main(String[] args) {
        String md5 = MD532.createPassword("sa");
        System.out.println("��888888��MD5ժҪ����ַ�����" + md5);
        String inputString = "sa";
        System.out.println("8888������ƥ�䣿" +
                MD532.authenticatePassword(md5, inputString));
        inputString = "123456";
        System.out.println("888888������ƥ�䣿" +
                MD532.authenticatePassword(md5, inputString));
    }

}