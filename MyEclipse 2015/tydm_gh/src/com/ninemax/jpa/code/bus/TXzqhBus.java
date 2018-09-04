package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TXzqhDAO;
import com.ninemax.jpa.code.model.ScXzqhdz;
import com.ninemax.jpa.code.model.TXzqh;
import com.ninemax.jpa.code.model.TXzqh1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ÏÂÎç4:22
 */
public class TXzqhBus {

    private TXzqhDAO dao = new TXzqhDAO();

    public TXzqh findXzqhByDm(String dm) {
        return dao.findById(dm);
    }

    public TXzqh1 findXzqhByDm1(String dm){
       return dao.findById1(dm);
    }

    public Map<String, String> getMap() {
        Map<String, String> hashMap = null;
        List<TXzqh> list = dao.findAll1();
        if (list != null && list.size() > 0) {
            hashMap = new HashMap<String, String>();
            for (TXzqh xzqh : list) {
                if (xzqh != null) {
                    hashMap.put(xzqh.getDm(), xzqh.getMc());
                }
            }
        }
        return hashMap;
    }
    public Map<String, String> getMap1() {
        Map<String, String> hashMap = null;
        List<TXzqh> list = dao.findAll2();
        if (list != null && list.size() > 0) {
            hashMap = new HashMap<String, String>();
            for (TXzqh xzqh : list) {
                if (xzqh != null) {
                    hashMap.put(xzqh.getDm(), xzqh.getMc());
                }
            }
        }
        return hashMap;
    }
    public Map<String, String> getMapNoSJ() {
        Map<String, String> hashMap = null;
        List<TXzqh> list = dao.findNoSJ();
        if (list != null && list.size() > 0) {
            hashMap = new HashMap<String, String>();
            for (TXzqh xzqh : list) {
                if (xzqh != null) {
                    hashMap.put(xzqh.getDm(), xzqh.getMc());
                }
            }
        }
        return hashMap;
    }
    
    
    public Map<String, ScXzqhdz> getMapXzqhDz() {
    	Map<String, ScXzqhdz> hashMap = null;
    	List<ScXzqhdz> list = dao.findAllXzqhDz();
    	if (list != null && list.size() > 0) {
    		hashMap = new HashMap<String, ScXzqhdz>();
    		for (ScXzqhdz xzqh : list) {
    			if (xzqh != null) {
    				hashMap.put(xzqh.getDm(), xzqh);
    			}
    		}
    	}
    	return hashMap;
    }
    
    public List<TXzqh> getListPage(String userInput, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(userInput, pageSize, pageNo, pageComponent);
    }


}
