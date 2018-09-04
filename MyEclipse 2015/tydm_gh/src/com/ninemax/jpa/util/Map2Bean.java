package com.ninemax.jpa.util;

import net.sf.sojo.common.ObjectUtil;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Date: 2010-3-23
 * Time: 18:48:37
 * To change this template use File | Settings | File Templates.
 */
public final class Map2Bean {

    private static Logger log = Logger.getLogger(Map2Bean.class);

    @SuppressWarnings(value="unchecked")     
    public static <T> T convert(Map<String, String[]> map, Class<T> c) {
        Map<String,String> _map = new HashMap<String,String>();
        for (String key : map.keySet()) {
            
            String[] value = map.get(key);

            if (value != null && value.length != 0) {

                _map.put(key, clsStringTool.convertMarks(value[0]));
                
            }
        }
        
        return (T) new ObjectUtil().makeComplex(_map, c);
    }
    
    @SuppressWarnings(value="unchecked")
    public static <T> T convert(Object obj,Class<T> c){
        HashMap<String, String> map = new HashMap<String,String>();
        try {

           map = getPropertyString(obj);

        } catch (Exception e) {
            log.error("Map2Bean convert error",e);
        }
        return  (T) new ObjectUtil().makeComplex(map, c);
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, String> getPropertyString(Object entityName) throws Exception {
        Class c = entityName.getClass();
        Field field[] = c.getDeclaredFields();
        HashMap<String, String> map = new HashMap<String, String>();

        for (Field f : field) {
            String filed_name = f.getName();
            filed_name = filed_name.substring(0,1).toLowerCase()+filed_name.substring(1);
            /*特殊判断，如果取出来的值等于"null"字符串，则要重新赋值为""*/
            String _temp = (String) invokeMethod(entityName, f.getName(), null);
            if(clsStringTool.isEmpty(_temp)){
                _temp = "";
            }
            map.put(filed_name, _temp.trim());
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    public static Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        Class ownerClass = owner.getClass();

        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);

        Method method = null;
        try {
            method = ownerClass.getMethod("get" + methodName);
        } catch (SecurityException e) {
            log.error(e);
        } catch (NoSuchMethodException e) {
            return " can't find 'get" + methodName + "' method";
        }

        return method.invoke(owner);
    }
}
