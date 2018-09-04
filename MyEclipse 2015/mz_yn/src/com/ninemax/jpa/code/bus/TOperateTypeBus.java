package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TOperateTypeDAO;
import com.ninemax.jpa.code.model.TOperateType;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: 下午6:28
 */
public class TOperateTypeBus {

    private TOperateTypeDAO dao = new TOperateTypeDAO();

    public List<TOperateType> findAll() {
        return dao.findAll();
    }

    public Map<String, String> getMap() {
        Map<String, String>   hashMap = new HashMap<String, String>();
        List<TOperateType> list = dao.findAll();
        if (list != null && list.size() > 0) {
           for (TOperateType operateType : list) {
                if (operateType != null) {
                    hashMap.put(operateType.getCzlxdm(), operateType.getCzlxmc());
                }
            }
        }
        return hashMap;
    }

    public Map<String, String> getMap2() {
        Map<String, String> hashMap = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        if (obj1 == null)
                            return -1;
                        return obj1.compareTo(obj2);
                    }
                });
        
        hashMap.put("1", "新办"); 
        hashMap.put("1A", "集中赋码");
        hashMap.put("2", "变更");
        hashMap.put("3", "注销");
        hashMap.put("6", "年检");
        hashMap.put("8", "换证");
        hashMap.put("M", "发证");
        hashMap.put("KP", "制卡");
        return hashMap;
    }
}
