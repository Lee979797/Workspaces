package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TSpdmtempDAO;
import com.ninemax.jpa.code.model.TSp;
import com.ninemax.jpa.code.model.TSpdmtemp;
import com.ninemax.jpa.global.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-29
 * Time: ÏÂÎç4:37
 */
public class TSpdmtempBus {

    private TSpdmtempDAO dao;

    public TSpdmtempBus() {
        dao = new TSpdmtempDAO();
    }

    public TSpdmtemp getSpdm(String jgdm, String ywlx) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        TSpdmtemp tspdm = null;
        try{
            String nameQuery = "select model from TSp model where model.tyshxydm='" + jgdm + "' and model.ywlx in (" + ywlx + ") and model.flag='1' ";
            List<TSp> sps = em.createQuery(nameQuery).getResultList();
            if (sps == null || sps.isEmpty() || sps.size() > 1) {
                return null;
            }
            tspdm = em.find(TSpdmtemp.class, sps.get(0).getGllsh());
        }catch (Exception e){}finally {
            EntityManagerHelper.closeEntityManager();
        }
        return  tspdm;
    }


    public TSpdmtemp getSpdmNoPass(String jgdm, String ywlx) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        TSpdmtemp  tspdm = null;
        try{
            String nameQuery = "select model from TSp model where model.jgdm='" + jgdm + "' and model.ywlx in (" + ywlx + ") and model.shflag='0' and model.flag='1' ";
            List<TSp> sps = em.createQuery(nameQuery).getResultList();
            if (sps == null || sps.isEmpty() || sps.size() > 1) {
                return null;
            }
            tspdm = em.find(TSpdmtemp.class, sps.get(0).getGllsh());
        }catch (Exception e){}finally {
            EntityManagerHelper.closeEntityManager();
        }

        return tspdm;
    }



    public String qzlx(String jgdm, String ywlx) {
        return getSpdm(jgdm, ywlx).getQzbz();
    }
}
