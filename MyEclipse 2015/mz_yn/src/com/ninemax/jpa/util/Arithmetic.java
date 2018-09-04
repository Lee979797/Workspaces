package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Arithmetic {
    private static String seed ="2523AD9546C6E3024ECEC5A3755D3CAF";// "63DD34F79B958973CD8151296E51CC4B";;
    private static Logger log = Logger.getLogger(Arithmetic.class);
    /**
     * �ַ����ӽ���
     *
     * @param str  ԭ�� �� ���� �ַ���
      * @return ���ش������ַ�������������typeֵ����ֱ�ӷ���ԭ�ַ���
     */
    public static String des(String str) {
        return des(str, seed);
    }

    public static String enc(String str) {
        return enc(str, seed);
    }

    public static SecretKeySpec getKey(String seed) {
        SecretKeySpec key = null;
        try {
            key = new SecretKeySpec(hex2byte(seed.getBytes()), "AES");
        } catch (Exception e) {
            log.error(Arithmetic.class,e);
        }
        return key;
    }

    /**
     * ����String��������,String�������
     *
     * @param strMing
     * @return
     */
    public static String enc(String strMing, String seed) {

        String strMi = "";
        try {
            return byte2hex(encCode(strMing.getBytes(), seed));

        } catch (Exception e) {
            log.error(Arithmetic.class,e);
        }
        return strMi;
    }

    /**
     * ���� ��String��������,String�������
     *
     * @param strMi
     * @return
     */
    public static String des(String strMi, String seed) {

        String strMing = "";
        try {
            return new String(desCode(hex2byte(strMi.getBytes()), seed));

        } catch (Exception e) {
            log.error(Arithmetic.class,e);
        }
        return strMing;
    }

    /**
     * ������byte[]��������,byte[]�������
     *
     * @param byteS
     * @return
     */
    private static byte[] encCode(byte[] byteS, String seed) {
        SecretKeySpec key = getKey(seed);
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byteS);
        } catch (Exception e) {
            log.error(Arithmetic.class,e);
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * ������byte[]��������,��byte[]�������
     *
     * @param byteDes ����
     * @param seed    ����
     * @return @see byte  ����
     */
    private static byte[] desCode(byte[] byteDes, String seed) {
        SecretKeySpec key = getKey(seed);
        Cipher cipher;
        byte[] byteFina = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(byteDes);
        } catch (Exception e) {
            log.error(Arithmetic.class,e);
        }
        return byteFina;
    }

    /**
     * ������ת�ַ���
     *
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) { // һ���ֽڵ�����
        // ת��16�����ַ���
        String hs = "";
        String temp;
        for (byte aB : bytes) {
            // ����ת��ʮ�����Ʊ�ʾ
            temp = (Integer.toHexString(aB & 0XFF));
            if (temp.length() == 1)
                hs = hs + "0" + temp;
            else
                hs = hs + temp;
        }
        return hs.toUpperCase(); // ת�ɴ�д
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("���Ȳ���ż��");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            // ��λһ�飬��ʾһ���ֽ�,��������ʾ��16�����ַ�������ԭ��һ�������ֽ�
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    public static void main(String[] args) {
        System.out.println("enc:" + Arithmetic.enc("6yhnbvcft"));
        System.out.println("���ܺ�:" + Arithmetic.enc("sa"));
        System.out.println("���ܺ�:" + Arithmetic.des("5B9256DDFD3E847DC65434366E18B29F"));
    }
} 
