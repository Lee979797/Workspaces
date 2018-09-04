package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TJjhyDAO;
import com.ninemax.jpa.code.model.TJjhy;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-20
 * Time: ÏÂÎç4:32
 */
public class TJjhyBus {

    private TJjhyDAO jjhyDAO = new TJjhyDAO();

    public List<TJjhy> getListPage(String mc, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return jjhyDAO.getListPage(mc, pageSize, pageNo, pageComponent);
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<TJjhy> list = jjhyDAO.findAll();
        if (list != null && list.size() > 0) {
            hashMap = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {
                            if (obj1 == null) {
                                return -1;
                            }
                            return obj1.compareTo(obj2);
                        }
                    });
            for (TJjhy jjhy : list) {
                if (jjhy != null) {
                    hashMap.put(jjhy.getDm().trim(), jjhy.getMc().trim());
                }
            }
        }
        return hashMap;
    }
    public Map<String, String> getBigMap() {
        Map<String, String> hashMap = null;
        List<TJjhy> list = jjhyDAO.findBigAll();
        if (list != null && list.size() > 0) {
            hashMap = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {
                            if (obj1 == null) {
                                return -1;
                            }
                            return obj1.compareTo(obj2);
                        }
                    });
            for (TJjhy jjhy : list) {
                if (jjhy != null) {
                    hashMap.put(jjhy.getDm().trim(), jjhy.getMc().trim());
                }
            }
        }
        return hashMap;
    }

}
