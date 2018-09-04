package com.ninemax.jpa.global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ninemax.jpa.code.dao.TSppzDAO;
import com.ninemax.jpa.code.model.TSppz;

public class TSppzBus {
	private TSppzDAO dao = new TSppzDAO();

    public Map<String, String> getMap() {
        Map<String, String> hashMap = new HashMap<String, String>();
        List<TSppz> list = dao.findAll();
        if (list != null && list.size() > 0) {
            for (TSppz zgjg : list) {
                if (zgjg != null) {
                    hashMap.put(zgjg.getYwlx(), zgjg.getYwmc());
                }
            }
        }
        return hashMap;
    }
}
