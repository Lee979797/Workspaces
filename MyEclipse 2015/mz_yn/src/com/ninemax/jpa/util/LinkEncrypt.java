package com.ninemax.jpa.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Gavin.lee
 * @descripte 该类包含了简单的BASE64加/解密方法；
 * 【约定密码:当前时间的秒数:用户名】的加/解密
 * 也对通信双方串进行连接检查
 */
public class LinkEncrypt {
    private static Logger log = Logger.getLogger(FileHelp.class);

    /**
     * 将加密参数进行解密,并返回
     *
     * @param loginName 加密的参数
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
     * 生成加密后的传递参数字符串
     *
     * @param secret   双方协定的连接密码
     * @param userName 用户名
     * @return 返回 [双方协定的连接密码]+[:]+[系统时间]+[:]+[用户名]
     */
    public String createPar(String secret, String userName) {
        if (secret == null || secret.trim().equals(""))
            return "";
        if (userName == null || userName.trim().equals(""))
            return "";
        String time = String.valueOf(System.currentTimeMillis() / 1000);
// time 是时间戳，就是自从 1970.1.1 00:00:00 到现在的秒数
        StringBuffer sb = new StringBuffer();
        sb.append(secret).append(":");
        sb.append(time).append(":");
        sb.append(userName);
        String loginName = encrypt(sb.toString());
        return loginName;
    }

    /**
     * 对字符串进行BASE64加密
     */
    public static String encrypt(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(str.getBytes());
    }

    /**
     * 对BASE64加密后的字符串进行解密
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
