package com.ninemax.jpa.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;


public class StringUtil {

    /**
     * 得到当前系统日期时间的字符串表示 如："2003-08-21 12:23:56"
     *
     * @return 当前系统日期时间的字符串表示
     */
    public static String getDateTime(Date date) {
        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.
                MEDIUM,
                DateFormat.
                        MEDIUM);
        return mediumDateFormat.format(new java.util.Date(date.getTime()));
    }

    public static String getTimestamp(Timestamp date) {
        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.
                MEDIUM,
                DateFormat.
                        MEDIUM);
        return mediumDateFormat.format(date);
    }

    public static String getBRString(String text) {
        if (text != null && text.indexOf("<") > -1) {
            text = text.replaceAll("<", "&lt;");
        }
        if (text != null && text.indexOf(">") > -1) {
            text = text.replaceAll(">", "&gt;");
        }
        if (text != null && text.indexOf("\n") > -1) {
            text = text.replaceAll("\n", "<br>");
        }
        return text;
    }

    public static String clearHtml(String str) {
        int flag1 = str.indexOf("<");
        int flag2 = str.indexOf(">");
        String temp = null;
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

    public static boolean getBadWordsInPost(String content) {
        HashMap hm = ForbidLoad.getInstance().getForbidwordsHm();
        String badWords = "";
        for (Object o : hm.values()) {
            badWords = (String) o;
            if (content.contains(badWords)) {

                return false;
            }
        }
        return true;
    }

    public static String subString(String str, int num) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < num;i++ ) {
            char temp = charArray[i];
            if (Character.getType(temp) == Character.OTHER_LETTER) {
                num-=1;
            }
        }
        return str.substring(0, num);
    }

    public static int ZHLength(String str) {
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
    public static void main(String[] args) {
        System.out.println("sub = " + ZHLength("a?й???"));
    }
}
