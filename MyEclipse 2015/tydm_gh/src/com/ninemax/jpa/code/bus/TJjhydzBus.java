package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TJjhydzDAO;
import com.ninemax.jpa.code.model.TJjhydz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-20
 * Time: ÏÂÎç4:32
 */
public class TJjhydzBus {

    private TJjhydzDAO jjhyDAO = new TJjhydzDAO();

//    public List<TJjhydz> getListPage(String mc,int pageSize, int pageNo, clsPageComponent pageComponent){
//        return jjhyDAO.getListPage(mc,pageSize,pageNo,pageComponent);
//    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<TJjhydz> list = jjhyDAO.findAll();
        if (list != null && list.size() > 0) {
            hashMap = new HashMap<String, String>();
            for (TJjhydz dz : list) {
                if (dz != null) {
                    hashMap.put(dz.getNewdm(), dz.getOlddm());
                }
            }
        }
        return hashMap;
    }

}
