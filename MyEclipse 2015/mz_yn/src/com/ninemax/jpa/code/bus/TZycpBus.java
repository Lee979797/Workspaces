package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.code.dao.TZycpDAO;
import com.ninemax.jpa.code.model.TZycp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ÏÂÎç3:42
 */
public class TZycpBus {

    private TZycpDAO dao = new TZycpDAO();

    public TZycp getZycp(String dm){
        return dao.findById(dm);
    }

    public Map<String,String> getMap(){
        Map<String,String> hashMap= new HashMap<String,String>();
        List<TZycp> list = dao.findAll();
        if(list!=null&&list.size()>0){
            for(TZycp zycp:list){
                if(zycp!=null){
                    hashMap.put(zycp.getDm().trim(),zycp.getMc());
                }
            }
        }
        return hashMap;
    }

    public List<TZycp> getListPage(String userInput, int pageSize, int pageNo, clsPageComponent pageComponent) {
        return dao.getListPage(userInput,pageSize,pageNo,pageComponent);
    }
}
