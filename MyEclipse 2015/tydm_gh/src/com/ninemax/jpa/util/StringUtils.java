package com.ninemax.jpa.util;

import java.util.UUID;

public class StringUtils {

    public static String clearHtml(String str) {
        int flag1 = str.indexOf("<");
        int flag2 = str.indexOf(">");
        while (flag1 != -1 || flag2 != -1) {
            str = clearHtmlPrivate(str);
            flag1 = str.indexOf("<");
            flag2 = str.indexOf(">");
        }
        return str;
    }

    private static String clearHtmlPrivate(String str) {
        int start = str.indexOf("<");
        int end = str.indexOf(">");
        if (start != -1 && end != -1) {
            str = str.substring(0, start) + str.substring(end + 1);
        }
        return str;
    }

    public static String subString(String str, int num) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < num; i++) {
            char temp = charArray[i];
            if (Character.getType(temp) == Character.OTHER_LETTER) {
                num -= 1;
            }
        }
        return str.substring(0, num);
    }

    public static int zHLength(String str) {
        char[] charArray = str.toCharArray();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = charArray[i];
            index++;
            if (Character.getType(temp) == Character.OTHER_LETTER) {
                index++;
            }
        }
        return index;
    }

    public static String toSBC(String input) {
        //半角转全角：
        char[] c = input.trim().toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 32) {
                c[i] = (char) 12288;
                continue;
            }
            if (c[i] < 127)
                c[i] = (char) (c[i] + 65248);
        }
        return new String(c);
    }

    /**
     * <summary>
     * /// 转半角的函数(DBC case)
     * /// </summary>
     * /// <param name="input">任意字符串</param>
     * /// <returns>半角字符串</returns>
     */
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println("sub = " + zHLength("a中国人"));
    }
    /**
     * UUID生成唯一的ID
     * @return UUID
     */
    public static String getUUID() {   
        UUID uuid = UUID.randomUUID();   
        String str = uuid.toString();   
        // 去掉"-"符号   
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);   
        return temp;   
    }
}
