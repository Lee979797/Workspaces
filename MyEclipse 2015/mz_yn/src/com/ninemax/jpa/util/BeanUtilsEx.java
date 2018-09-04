package com.ninemax.jpa.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: 下午3:31
 */
public class BeanUtilsEx extends BeanUtils {
    private static Logger log = Logger.getLogger(BeanUtilsEx.class);

    static {
        ConvertUtils.register(new DateConvert(), java.util.Date.class);
        ConvertUtils.register(new DateConvert(), java.sql.Date.class);
        ConvertUtils.register(new DateConvert(), Timestamp.class);
    }

    /**
     * @param dest 目标
     * @param orig 源
     */
    public static void copyProperties(Object dest, Object orig) {
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            log.error(BeanUtilsEx.class, e);
        } catch (InvocationTargetException e) {
            log.error(BeanUtilsEx.class, e);
        }
    }

    /**
     * @param dest   目标
     * @param orig   源
     * @param filter 1过滤 数据库字段长度,2过滤空值
     */
    public static void copyProperties(Object dest, Object orig, Integer filter,EntityManager em, String name) {
        try {
            if (filter == 1) {
                Map<String, Integer> fieldLength = MetaDataUtil.getFieldLength(em, name);
                Map<Object, Object> objectMap = BeanUtilsEx.describe(orig);
                for (Map.Entry<Object, Object> entry : objectMap.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null)
                        continue;
                    if (value instanceof Date || value instanceof Boolean) {
                        objectMap.put(key, value);
                        continue;
                    }
                    if (value instanceof String) {
                        Integer length = fieldLength.get(key.toString().toLowerCase().trim());
                        Integer zhLength = StringUtils.zHLength((String) value);
                        if (length != null && length < zhLength) {
                            String value2 = StringUtils.subString((String) value, length - 1);
                            objectMap.put(key, value2);
                        } else {
                            objectMap.put(key, value);
                        }
                    } else {
                        objectMap.put(key, value);
                    }

                }
                BeanUtilsEx.copyProperties(dest, objectMap);
            } else if (filter == 2) {
                Map<Object, Object> destMap = BeanUtilsEx.describe(dest);
                Map<Object, Object> origMap = BeanUtilsEx.describe(orig);
                for (Map.Entry<Object, Object> entry : origMap.entrySet()) {
                    if (entry.getValue() == null) {
                        continue;
                    }
                    destMap.put(entry.getKey(), entry.getValue());
                }
                copyProperties(dest, destMap);
            } else {
                copyProperties(dest, orig);
            }
        } catch (IllegalAccessException e) {
            log.error(BeanUtilsEx.class, e);
        } catch (InvocationTargetException e) {
            log.error(BeanUtilsEx.class, e);
        } catch (NoSuchMethodException e) {
            log.error(BeanUtilsEx.class, e);
        } catch (Exception e) {
            log.error(BeanUtilsEx.class, e);
        }
    }

}
