package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-12-19
 * Time: ÏÂÎç2:26
 */
public class HandleBus {

    public EntityManager em = null;

    private Boolean isMain(String bzjgdm) {
        em = EntityManagerHelper.getEntityManager();
        try {
            TZrxzqh zrxzqh = em.find(TZrxzqh.class, bzjgdm);
            return zrxzqh.getBzjgflag() == null ? true : zrxzqh.getBzjgflag();
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return true;
    }

    public List<String> getXzqhs(String bzjgdm) {
        em = EntityManagerHelper.getEntityManager();
        List<String> bzjgdms = new ArrayList<String>();
        try {
            List<TZrxzqh> xzqhs = em.createQuery("SELECT model from TZrxzqh model where  model.csxzqh=:bzjgdm").setParameter("bzjgdm", bzjgdm).getResultList();
            for (TZrxzqh zrxzqh : xzqhs) {
                bzjgdms.add(zrxzqh.getXzqh());
            }
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return bzjgdms;
    }

    public String sql(User user) {
        String sql = "";
        String bzjgdm = user.getBzjgdm();

        if (user.getUserName().equals("admin")) {
        	return " 1=1  ";
        }else{
        	
        	sql = " model.bzjgdm='" + bzjgdm + "' ";
        }
       
        return sql;
    }

}
