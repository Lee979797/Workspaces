package com.ninemax.common.util;

import org.apache.shiro.SecurityUtils;

public class ShiroUtils {
    private ShiroUtils() {
    }

    public static String getPrincipal() {
        return (String) SecurityUtils.getSubject().getPrincipal();
    }
}
