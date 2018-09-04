package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Arithmetic {
    private static String seed ="2523AD9546C6E3024ECEC5A3755D3CAF";// "63DD34F79B958973CD8151296E51CC4B";;
    private static Logger log = Logger.getLogger(Arithmetic.class);
    /**
     * 字符串加解密
     *
     * @param str  原文 或 密文 字符串
      * @return 返回处理后的字符串，如果传入的type值错误，直接返回原字符串
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
     * 加密String明文输入,String密文输出
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
     * 解密 以String密文输入,String明文输出
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
     * 加密以byte[]明文输入,byte[]密文输出
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
     * 解密以byte[]密文输入,以byte[]明文输出
     *
     * @param byteDes 密文
     * @param seed    种子
     * @return @see byte  明文
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
     * 二行制转字符串
     *
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) { // 一个字节的数，
        // 转成16进制字符串
        String hs = "";
        String temp;
        for (byte aB : bytes) {
            // 整数转成十六进制表示
            temp = (Integer.toHexString(aB & 0XFF));
            if (temp.length() == 1)
                hs = hs + "0" + temp;
            else
                hs = hs + temp;
        }
        return hs.toUpperCase(); // 转成大写
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    public static void main(String[] args) {
        System.out.println("enc:" + Arithmetic.enc("6yhnbvcft"));
        System.out.println("加密后:" + Arithmetic.enc("sa"));
        System.out.println("解密后:" + Arithmetic.des("5B9256DDFD3E847DC65434366E18B29F"));
    }
} 
