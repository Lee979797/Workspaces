package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TPzjgDAO;
import com.ninemax.jpa.code.model.TPzjg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-20
 * Time: ÏÂÎç4:43
 */
public class TPzjgBus {

    private TPzjgDAO dao = new TPzjgDAO();

    public List<TPzjg> getListPage(String mc, String bzjgdm, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(mc, bzjgdm, pageSize, pageNo, pageComponent);
    }

    public List<TPzjg> getAll() {
        return dao.getAll();
    }

    public Map<String, Map<String, String>> getMap() {
        Map<String, Map<String, String>> bzjgPzjgMaps = new HashMap<String, Map<String, String>>();
        Map<String, String> map;
        List<TPzjg> list = dao.findAll();
        if (list != null && list.size() > 0) {
            for (TPzjg pzjg : list) {
                if (pzjg != null) {
                    map = bzjgPzjgMaps.get(pzjg.getId().getBzjgdm());
                    if (map == null) {
                        map = new HashMap<String, String>();
                        bzjgPzjgMaps.put(pzjg.getId().getBzjgdm(), map);
                    }
                    map.put(pzjg.getId().getPzjgdm(), pzjg.getPzjgmc());
                }
            }
        }
        return bzjgPzjgMaps;
    }

}
