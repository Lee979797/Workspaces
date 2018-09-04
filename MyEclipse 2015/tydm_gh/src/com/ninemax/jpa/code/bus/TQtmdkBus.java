package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TQtmdkDAO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-8
 * Time: ÏÂÎç6:30
 */
public class TQtmdkBus {

    private TQtmdkDAO dao;

    public TQtmdkBus() {
        this.dao = new TQtmdkDAO();
    }

    public boolean existCode(String jgdm,int flag) {
        List list = dao.findByPropertyAndFlag("jgdm", jgdm,flag);
        if (list != null && list.size() > 0) {
            return true;
        } else
            return false;
    }
}
