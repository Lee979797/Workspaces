package com.ninemax.jpa.code.bus;


import com.ninemax.jpa.code.dao.TkKxxkDAO;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TkFzk;
import com.ninemax.jpa.code.model.TkKxxk;
import com.ninemax.jpa.system.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ÏÂÎç6:21
 */
public class TkKxxkBus {
    private TkKxxkDAO dao = new TkKxxkDAO();

    public boolean checkICForWrite(String jgdm) {
        String sql = "select model from TkKxxk model  where model.kxlh is null  and model.jgdm='" + jgdm + "'";
        List<TkKxxk> kxxks = dao.findbyhql(sql);
        if ((kxxks == null) || kxxks.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkICForLoss(String jgdm) {
        String sql = "select model from TkKxxk model  where model.kxlh is not null  and model.jgdm='" + jgdm + "'";
        List<TkKxxk> kxxks = dao.findbyhql(sql);
        if ((kxxks == null) || kxxks.isEmpty()) {
            return false;
        }
        return true;
    }

}
