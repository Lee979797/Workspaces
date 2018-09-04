package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TJjlxdzDAO;
import com.ninemax.jpa.code.model.TJjlxdz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-20
 * Time: ÏÂÎç4:36
 */
public class TJjlxdzBus {

    private TJjlxdzDAO dao = new TJjlxdzDAO();

    public Map<String,String> getMap(){
        Map<String,String> hashMap = null;
        List<TJjlxdz> list = dao.findAll();
        if(list!=null&&list.size()>0){
            hashMap = new HashMap<String,String>();
            for(TJjlxdz njjlx:list){
                if(njjlx!=null){
                    hashMap.put(njjlx.getNewdm(),njjlx.getOlddm());
                }
            }
        }
        return hashMap;
    }
}
