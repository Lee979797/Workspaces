package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TSmrw;
import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.util.DateUtil;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Liuzy
 */
public class TSmrwDAO extends BaseDao {
    private static Logger log = Logger
            .getLogger(TSmTaskDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TSmrw findById(Integer id) {
        log.info("finding SmTask instance with id: " + id);
        try {
            TSmrw instance = getEntityManager().find(TSmrw.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TSmrw> findByProperty(String propertyName, final Object value) {
        log.info("finding TSmrw instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TSmrw model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TSmrw> findByHql(String sql) {
        log.info("finding all sql's data instances");
        try {
            Query query = getEntityManager().createQuery(sql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    private List<String> getXzqhs(String bzjg) {
        List<TZrxzqh> xzqhs =  getEntityManager().createQuery("SELECT model from TZrxzqh model where  model.csxzqh=:bzjgdm").setParameter("bzjgdm",bzjg).getResultList();
        List<String> bzjgdms = new ArrayList<String>();
        for (TZrxzqh zrxzqh : xzqhs) {
            bzjgdms.add(zrxzqh.getXzqh());
        }
        EntityManagerHelper.closeEntityManager();
        return bzjgdms;
    }
    public List<TSmrw> findByDate(String bzjg) {
        log.info("finding all sql's data instances");
        try {
            String sql = "";
            List<String> xzqhs = getXzqhs(bzjg);
            if ( xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
                sql = " model.bzjgdm='" +bzjg + "' ";
            } else {
                sql = " model.bzjgdm in ('";
                for (String bzjgdm : xzqhs) {
                    sql += bzjgdm + "','";
                }
                sql = sql.substring(0, sql.lastIndexOf(",'"));
                sql += ") ";
            }

            if(InitSysParams.system.getSmqx()==0)
                return null;
            Query query = getEntityManager().createQuery("select model from TSmrw  model where "+sql+" and model.status=false and model.createTime<:date")
                    .setParameter("date", DateUtil.dayBefore(new Date(), InitSysParams.system.getSmqx()));
            return query.getResultList();
        } catch (RuntimeException re) {
             log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}