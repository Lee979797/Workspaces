package com.ninemax.jpa.util;

import org.apache.commons.beanutils.Converter;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ÏÂÎç3:29
 */
public class DateConvert implements Converter {
    private static Logger log = Logger.getLogger(DateConvert.class);
    private static String dateFormatStr = "yyyy/MM/dd";
    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(dateFormatStr);

    public Object convert(Class arg0, Object arg1) {
        if (arg1 == null)
            return null;
        String className = arg1.getClass().getName();
        //java.sql.Timestamp
        if ("java.sql.Timestamp".equalsIgnoreCase(className)) {
            try {
                SimpleDateFormat df = new SimpleDateFormat(dateFormatStr + " HH:mm:ss");
                return df.parse(dateTimeFormat.format(arg1));
            } catch (Exception e) {
                try {
                    SimpleDateFormat df = new SimpleDateFormat(dateFormatStr);
                    return df.parse(dateTimeFormat.format(arg1));
                } catch (ParseException ex) {
                    log.error(e);
                    return null;
                }
            }
        }
        if (arg1 instanceof String) {

            String p = (String) arg1;
            if (p.trim().length() == 0) {
                return null;
            }
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.parse(p.trim());
            } catch (Exception e) {
                try {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    return df.parse(p.trim());
                } catch (ParseException ex) {
                    return null;
                }
            }

        }
        return arg1;
    }
}
