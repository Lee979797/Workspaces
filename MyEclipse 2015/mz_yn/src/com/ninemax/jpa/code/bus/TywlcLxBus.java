package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TywlcLxDAO;
import com.ninemax.jpa.code.model.ScanManage;
import com.ninemax.jpa.code.model.TYwlcLx;
import com.ninemax.jpa.global.EntityManagerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-10-25
 * Time: ÏÂÎç2:25
 */
public class TywlcLxBus {

    private TywlcLxDAO dao;

    public TywlcLxBus(){
        dao = new TywlcLxDAO();
    }

    public List<TYwlcLx> getTywlcLxList(){
        return dao.findByProperty("type","0");
    }
    public List<TYwlcLx> findAll(){
    	return dao.findAll();
    }

    public List<TYwlcLx> getTywlcLx(int dm){
        return dao.findByProperty("czlxdm",dm);
    }
}
