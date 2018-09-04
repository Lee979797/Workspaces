package com.ninemax.jpa.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Arithmetic_ {


    public static SecretKeySpec getKey(String seed) {
        SecretKeySpec key = null;
        try {
            key = new SecretKeySpec(hex2byte(seed.getBytes()), "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }

    /**
     * ����String��������,String�������
     *
     * @param strMing
     * @return
     */
    public static String getEncString(String strMing, String seed) {
        byte[] byteMi = null;
        byte[] byteMing = null;
        String strMi = "";
        try {
            return byte2hex(getEncCode(strMing.getBytes(), seed));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            byteMing = null;
            byteMi = null;
        }
        return strMi;
    }

    /**
     * ���� ��String��������,String�������
     *
     * @param strMi
     * @return
     */
    public static String getDesString(String strMi, String seed) {
        byte[] byteMing = null;
        byte[] byteMi = null;
        String strMing = "";
        try {
            return new String(getDesCode(hex2byte(strMi.getBytes()), seed));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            byteMing = null;
            byteMi = null;
        }
        return strMing;
    }

    /**
     * ������byte[]��������,byte[]�������
     *
     * @param byteS
     * @return
     */
    private static byte[] getEncCode(byte[] byteS, String seed) {
        SecretKeySpec key = getKey(seed);
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byteS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * ������byte[]��������,��byte[]�������
     *
     * @param byteD
     * @return
     */
    private static byte[] getDesCode(byte[] byteD, String seed) {
        SecretKeySpec key = getKey(seed);
        Cipher cipher;
        byte[] byteFina = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(byteD);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * ������ת�ַ���
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) { // һ���ֽڵ����� 
        // ת��16�����ַ��� 
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            // ����ת��ʮ�����Ʊ�ʾ 
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
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
        String seed = "63DD34F79B958973CD8151296E51CC4B";
        String test1 = Arithmetic_.getEncString("�������Ķ��Žӿ����ݷ��Ͳ���", seed);//
        System.out.println("sss:" + test1);
        String test2 = Arithmetic_.getDesString("472025E8AD0901A1F306440F8D1AEA597A44323621FC4380030384ECBF2438A9", seed);
        System.out.println("ttt:" + test2);

    }
}
