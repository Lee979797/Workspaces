package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TXzqh1DAO;
import com.ninemax.jpa.code.model.TXzqh1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-28
 * Time: ÏÂÎç1:15
 */
public class TXzqhBus1 {

    private TXzqh1DAO dao;

    public TXzqhBus1(){
        dao = new TXzqh1DAO();
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<TXzqh1> list = dao.findAll();
        if (list != null && list.size() > 0) {
            hashMap = new HashMap<String, String>();
            for (TXzqh1 xzqh : list) {
                if (xzqh != null) {
                    hashMap.put(xzqh.getDm(), xzqh.getMc());
                }
            }
        }
        return hashMap;
    }

}
