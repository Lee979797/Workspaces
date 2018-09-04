package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TZjlxDAO;
import com.ninemax.jpa.code.model.TZjlx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ÏÂÎç6:25
 */
public class TZjlxBus {

    private TZjlxDAO zjlxDAO = new TZjlxDAO();

    public List<TZjlx> findAll() {
        return zjlxDAO.findAll();
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<TZjlx> list = zjlxDAO.findAll();
        if (list != null && list.size() > 0) {
            hashMap = new HashMap<String, String>();
            for (TZjlx tNjjhy : list) {
                if (tNjjhy != null) {
                    hashMap.put(tNjjhy.getDm(), tNjjhy.getMc());
                }
            }
        }
        return hashMap;
    }

}
