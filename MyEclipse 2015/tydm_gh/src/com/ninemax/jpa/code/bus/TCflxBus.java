package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TCflxDAO;
import com.ninemax.jpa.code.model.TCflx;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ÏÂÎç6:25
 */
public class TCflxBus {

    private TCflxDAO dao = new TCflxDAO();

    public List<TCflx> findAll() {
        return dao.findAll();
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<TCflx> list = dao.findAll();
        if (list != null && list.size() > 0) {
            hashMap = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {
                            if(obj1==null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    });
            for (TCflx gj : list) {
                if (gj != null) {
                    hashMap.put(gj.getDm(), gj.getMc());
                }
            }
        }
        return hashMap;
    }

}
