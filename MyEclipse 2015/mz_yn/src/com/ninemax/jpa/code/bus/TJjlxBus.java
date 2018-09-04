package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TJjlxDAO;
import com.ninemax.jpa.code.model.TJjlx;
import com.ninemax.jpa.code.model.TNNjjlx;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-20
 * Time: ÏÂÎç4:39
 */
public class TJjlxBus {

    private TJjlxDAO dao = new TJjlxDAO();
    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<TJjlx> list = dao.findAll();
        if (list != null && list.size() > 0) {
            hashMap =new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {

                            if(obj1==null)
                                return -1;
                            return obj1.compareTo(obj2);
                        }
                    });
            for (TJjlx jjlx : list) {
                if (jjlx != null) {
                    hashMap.put(jjlx.getDm().trim(), jjlx.getMc());
                }
            }
        }
        return hashMap;
    }
    public List<TJjlx> getListPage(String mc,int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(mc,pageSize,pageNo,pageComponent);
    }
    public List<TNNjjlx> findAlljjlx2011(){
    	return dao.findAlljjlx2011();
    }

}
