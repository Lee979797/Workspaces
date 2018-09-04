package com.ninemax.jpa.code.bus;


import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.ScBzjgdmDAO;
import com.ninemax.jpa.code.model.ScBzjgdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: 下午6:21
 */
public class ScBzjgdmBus {

    private ScBzjgdmDAO dao = new ScBzjgdmDAO();

    public List<ScBzjgdm> findAll() {
        return dao.findAll();
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<ScBzjgdm> list = dao.findAll();
        if (list != null && list.size() > 0) {
            hashMap = new HashMap<String, String>();
            for (ScBzjgdm tNjjhy : list) {
                if (tNjjhy != null) {
                    hashMap.put(tNjjhy.getDm(), tNjjhy.getMc());
                }
            }
        }
        return hashMap;
    }

    public List<ScBzjgdm> getListPage(String userInput, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(userInput, pageSize, pageNo, pageComponent);
    }

    /**
     * 根据dm查询实体
     *
     * @param dm
     * @return
     */
    public ScBzjgdm findByDm(String dm) {
        return dao.findById(dm);
    }
}
