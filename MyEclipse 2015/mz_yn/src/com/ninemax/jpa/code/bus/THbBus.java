package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.THbDAO;
import com.ninemax.jpa.code.model.THb;
import com.ninemax.jpa.code.model.TJglx;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ÏÂÎç6:28
 */
public class THbBus {

    private THbDAO dao = new THbDAO();

    public List<THb> findAll(){
        return dao.findAll();
    }
    public List<THb> getListPage(String mc,int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(mc,pageSize,pageNo,pageComponent);
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        if (obj1 == null)
                            return -1;

                        return obj1.compareTo(obj2);
                    }
                });
        List<THb> list = dao.findAll();
        if (list != null && list.size() > 0) {
            for (THb hb : list) {
                if (hb != null) {
                    hashMap.put(hb.getDm(), hb.getMc());
                }
            }
        }
        return hashMap;
    }
    public Map<String,String> getMap4(){
        Map<String,String> hashMap = null;
        //List<THb> list = dao.findAll();

        return hashMap;
    }
}
