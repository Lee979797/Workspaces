package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TNjjlxDAO;
import com.ninemax.jpa.code.model.TNNjjlx;
import com.ninemax.jpa.code.model.TNjjlx;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-20
 * Time: ÏÂÎç4:36
 */
public class TNjjlxBus {

    private TNjjlxDAO dao = new TNjjlxDAO();

    public List<TNjjlx> getListPage(String mc, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(mc, pageSize, pageNo, pageComponent);
    }

    public List<TNNjjlx> get2k1ListPage(String mc, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.get2k1ListPage(mc, pageSize, pageNo, pageComponent);
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<TNjjlx> list = dao.findAll();
        if (list != null && list.size() > 0) {
            hashMap = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {

                            if (obj1 == null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    });
            for (TNjjlx njjlx : list) {
                if (njjlx != null) {
                    hashMap.put(njjlx.getDm(), njjlx.getMc());
                }
            }
        }
        return hashMap;
    }

    public Map<String, String> get2k1Map() {
        Map<String, String> hashMap = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {

                        if (obj1 == null)
                            return -1;
                        return obj1.compareTo(obj2);
                    }
                });
        List<TNNjjlx> list = dao.find2k1All();
        if (list != null && list.size() > 0) {
            for (TNNjjlx njjlx : list) {
                if (njjlx != null) {
                    hashMap.put(njjlx.getDm(), njjlx.getMc());
                }
            }
        }
        return hashMap;
    }
}
