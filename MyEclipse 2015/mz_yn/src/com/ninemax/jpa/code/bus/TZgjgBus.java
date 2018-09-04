package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TZgjgDAO;
import com.ninemax.jpa.code.model.TZgjg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-22
 * Time: ÉÏÎç10:13
 */
public class TZgjgBus {

    private TZgjgDAO dao = new TZgjgDAO();

    public Map<String, String> getMap() {
        Map<String, String> hashMap = new HashMap<String, String>();
        List<TZgjg> list = dao.findAll();
        if (list != null && list.size() > 0) {
            for (TZgjg zgjg : list) {
                if (zgjg != null) {
                    hashMap.put(zgjg.getDm(), zgjg.getMc());
                }
            }
        }
        return hashMap;
    }

    public List<TZgjg> getListPage(String userInput, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(userInput, pageSize, pageNo, pageComponent);
    }
}
