package com.ninemax.jpa.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-14
 * Time: ионГ9:30
 * To change this template use File | Settings | File Templates.
 */
public class RegTest {
    public static void main(String[] args) {
        String pattern = "^(([1-9]\\d{1,8})|(\\d{1,9}\\.\\d{1,4}))$";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher("0.0");
        //System.out.println("matcher.find() = " + matcher.find());
    }
}
