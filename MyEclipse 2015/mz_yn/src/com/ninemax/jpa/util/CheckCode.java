package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * CheckCode�� ���ܣ����������������㷨�����֤�ŵ��㷨
 *
 * @author songqw
 */
public class CheckCode {

    private static Logger log = Logger.getLogger(CheckCode.class);

    /**
     * getCheckCode()����,���� ���ܣ����ɻ�������ļ�����,���������ǰ8λ,ת��Ϊ��λ�Ļ�������
     *
     * @param sCode String ���������ǰ8λ
     * @return String ��������Ļ�������
     */
    public static String getCheckCode(String sCode) {
        sCode = sCode.toUpperCase();
        int[] wi = {3, 7, 9, 10, 5, 8, 4, 2};
        int i, sum = 0;
        String[] strKey = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z"};
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                30, 31, 32, 33, 34, 35};
        String strCheck = "";

        Map<String, Integer> hashData = null;
        hashData = new HashMap();
        // �����������еĸ�����ĸ,������Ӧ��ֵ�ŵ�hashtable��
        for (int j = 0; j < strKey.length; j++) {
            hashData.put(strKey[j], values[j]);
        }
        
        // ���ռ����㷨��������
        for (i = 0; i < 8; i++) {
            strCheck = sCode.substring(i, i + 1);
            sum = sum + wi[i] * hashData.get(strCheck);
        }
        sum = 11 - sum % 11;
        if (sum == 10) {
            strCheck = sCode + "X";
        } else if (sum == 11) {
            strCheck = sCode + Integer.toString(0);
        } else {
            strCheck = sCode + Integer.toString(sum);
        }
        return strCheck;

    }

    /**
     * isCheckCode()���� ���ܣ�����˻��������Ƿ��������Ҫ��
     *
     * @param aStrCode String 9λ��������
     * @return boolean
     */

    public static boolean isCheckCode(String aStrCode) {
        String strOrigin = "";
        if (aStrCode == null || aStrCode.length() < 9)
            return false;

        if (aStrCode.length() >= 9) {
            strOrigin = aStrCode.substring(0, 8).toUpperCase();
        } else {
            return false;
        }

        boolean hasSymble = !aStrCode.matches("^[\\da-zA-Z]*$");
        if(hasSymble){
            return false;
        }

        strOrigin = getCheckCode(strOrigin);
        if (strOrigin.equals(aStrCode)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * getIDCheckCode()����,���� ���ܣ����ڴ�18λ�����֤���������������Ĵ���,����ǰ17λ�����ɼ����� ISO
     * 7064:1983.MOD 11-2У����
     *
     * @param sCode String ���֤��ǰ17λ
     * @return String ������������֤��18λ
     */
    public static String getIDCheckCode(String sCode) {
        int[] wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
        int i, sum = 0;
        String[] ai = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        String strCheck = "";
        // ���ռ����㷨��������
        for (i = 0; i < 17; i++) {
            strCheck = sCode.substring(i, i + 1);
            sum = sum + wi[i] * Integer.parseInt(strCheck);
        }
        sum = sum % 11;

        strCheck = sCode + ai[sum];
        // sCheck=sCode+Integer.toString(sum);
        return strCheck;
    }

    /**
     * isIDCheckCode()���� ���ܣ��������֤�Ƿ��������Ҫ��
     *
     * @param aStrCode String 18λ��������
     * @return boolean
     */
    public static boolean isIDCheckCode(String aStrCode) {
        String strOrigin = "";
        strOrigin = aStrCode.substring(0, 17);
        strOrigin = getIDCheckCode(strOrigin);
        if (strOrigin.equals(aStrCode)) {
            return true;
        } else {
            return false;
        }
    }
    
    
    /**
     * isCheckTydm()���� ���ܣ������ͳһ��������Ƿ��������Ҫ��
     *
     * @param aStrCode String 18λͳһ����
     * @return boolean
     */

    public static boolean isCheckTydm(String aStrCode) {
        String strOrigin = "";
        if (aStrCode == null || aStrCode.length() < 18)
            return false;

        if (aStrCode.length() >= 18) {
            strOrigin = aStrCode.substring(0, 17).toUpperCase();
        } else {
            return false;
        }

        boolean hasSymble = !aStrCode.matches("^[\\da-zA-Z]*$");
        if(hasSymble){
            return false;
        }

        strOrigin = getCheckTydm(strOrigin);
        if (strOrigin.equals(aStrCode)) {
            return true;
        } else {
            return false;
        }
    }
    

    public static String getCheckTydm(String sCode) {
        sCode = sCode.toUpperCase();
       int[] wi = {1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28};
        
        String[] strKey = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "A", "B", "C", "D", "E", "F", "G", "H",  "J", "K", "L",
                "M", "N",  "P", "Q", "R", "T","U" ,"W",  "X","Y","0"
                };
        int i, sum = 0;

        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                30,31};
        String strCheck = "";

        Map<String, Integer> hashData = null;
        hashData = new HashMap();
        // �����������еĸ�����ĸ,������Ӧ��ֵ�ŵ�hashtable��
        for (int j = 0; j < strKey.length; j++) {
            hashData.put(strKey[j], values[j]);
        }
        // ���ռ����㷨��������
        for (i = 0; i < 17; i++) {
            strCheck = sCode.substring(i, i + 1);
            sum = sum + wi[i] * hashData.get(strCheck);
        }
        System.out.println("sum1:"+sum);
        sum = 31 - sum % 31;

        System.out.println("sum2:"+sum);
        
        strCheck= sCode+ strKey[sum];
        System.out.println("ǰ17λ  ��"+sCode);
        System.out.println("��������"+strCheck);
        return strCheck;

    }
}