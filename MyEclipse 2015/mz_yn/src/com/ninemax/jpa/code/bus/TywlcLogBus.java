package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TywlcLogDAO;
import com.ninemax.jpa.code.model.TYwlcLog;
import com.ninemax.nacao.util.clsStringTool;
import org.apache.commons.collections.map.HashedMap;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-11-2
 * Time: ÏÂÎç5:54
 */
public class TywlcLogBus {

    private TywlcLogDAO dao = new TywlcLogDAO();

    public List<TYwlcLog> findList(String ywlsh,String jgdm) {
        Map<String, Object> params = new HashedMap();
        if(!clsStringTool.isEmpty(jgdm)){
            params.put("jgdm", jgdm);
        }
        if(!clsStringTool.isEmpty(ywlsh)){
            params.put("ywlsh",ywlsh);
        }
        return dao.findByPropertys(params);
    }

}
