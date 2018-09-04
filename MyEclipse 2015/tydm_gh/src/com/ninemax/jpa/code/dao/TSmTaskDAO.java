package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.DFile0;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TSmrw;
import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.ninemax.jpa.system.model.User;
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
public class TSmTaskDAO extends BaseDao {

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
            log.error(TSmTaskDAO.class, re);
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
        List<TZrxzqh> xzqhs = getEntityManager().createQuery("SELECT model from TZrxzqh model where  model.csxzqh=:bzjgdm").setParameter("bzjgdm", bzjg).getResultList();
        List<String> bzjgdms = new ArrayList<String>();
        bzjgdms.add(bzjg);
        for (TZrxzqh zrxzqh : xzqhs) {
            bzjgdms.add(zrxzqh.getXzqh());
        }
        EntityManagerHelper.closeEntityManager();
        return bzjgdms;
    }

    public List<DFile0> findDfile(String bzjg) {
        log.info("finding all sql's data instances");
        try {
            String sql = "";
            List<String> xzqhs = getXzqhs(bzjg);
            if (xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
                sql = " model.bzjgdm='" + bzjg + "' ";
            } else {
                sql = " model.bzjgdm in ('";
                for (String bzjgdm : xzqhs) {
                    sql += bzjgdm + "','";
                }
                sql = sql.substring(0, sql.lastIndexOf(",'"));
                sql += ") ";
            }
            if (InitSysParams.system.getDaqx() == null || InitSysParams.system.getDaqx() == 0)
                return null;
            int date = InitSysParams.system.getDaqx();
            date += InitSysParams.zrxzqhMap2.get(bzjg).getDayq() == null ? 0 : InitSysParams.zrxzqhMap2.get(bzjg).getDayq();
            //  date += user.getYqsj() == null ? 0 : user.getYqsj();
            Query query = ThamsEntityManagerHelper.getEntityManager().createQuery("select model from DFile0 model where  " + sql + " and  model.status!=-1 and  model.attr=2  and   model.errorflag<>-2   and model.edittime<:date")
                    .setParameter("date", DateUtil.dayBefore(DateUtil.strToDate(DateUtil.dateToStr(new Date())), InitSysParams.system.getSmqx()));
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(TSmTaskDAO.class, re);
            throw re;
        } finally {
            ThamsEntityManagerHelper.closeEntityManager();
        }
    }

    public Integer findDfiles(User user) {
        log.info("finding all sql's data instances");
        try {
            String bzjg = user.getBzjgdm().trim();
            String sql = "";
            List<String> xzqhs = getXzqhs(bzjg);
            if (xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
                sql = " model.bzjgdm='" + bzjg + "' ";
            } else {
                sql = " model.bzjgdm in ('";
                for (String bzjgdm : xzqhs) {
                    sql += bzjgdm + "','";
                }
                sql = sql.substring(0, sql.lastIndexOf(",'"));
                sql += ") ";
            }
            if (InitSysParams.system.getDaqx() == null || InitSysParams.system.getDaqx() == 0)
                return 0;
            int date = InitSysParams.system.getDaqx() == null ? 0 : InitSysParams.system.getDaqx();
            date += InitSysParams.zrxzqhMap2.get(bzjg).getDayq() == null ? 0 : InitSysParams.zrxzqhMap2.get(bzjg).getDayq();
            date += user.getYqsj() == null ? 0 : user.getYqsj();
            return ThamsEntityManagerHelper.getEntityManager().createQuery("select model from DFile0 model where  " + sql + " and  model.status!=-1 and  model.attr=2  and   model.errorflag<>-2  and  model.edittime <?1 ").setParameter(1,DateUtil.dayBefore(DateUtil.strToDate(DateUtil.dateToStr(new Date())), date)).getResultList().size();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            ThamsEntityManagerHelper.closeEntityManager();
        }
    }

    public Integer findProblemDatas(User user) {
        log.info("finding all sql's data instances");
        try {
            String bzjg = user.getBzjgdm().trim();
            String sql = "";
            List<String> xzqhs = getXzqhs(bzjg);
            if (xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
                sql = " model.bzjgdm='" + bzjg + "' ";
            } else {
                sql = " model.bzjgdm in ('";
                for (String bzjgdm : xzqhs) {
                    sql += bzjgdm + "','";
                }
                sql = sql.substring(0, sql.lastIndexOf(",'"));
                sql += ") ";
            }
            if (InitSysParams.system.getSjqx() == null || InitSysParams.system.getSjqx() == 0)
                return 0;
            int date = InitSysParams.system.getSjqx();
            date += InitSysParams.zrxzqhMap2.get(bzjg).getSjyq() == null ? 0 : InitSysParams.zrxzqhMap2.get(bzjg).getSjyq();
            date += user.getYqsj() == null ? 0 : user.getYqsj();
            List<TJgdm> dms = EntityManagerHelper.getEntityManager().createNativeQuery("select * from t_jgdm model where cast(model.memo_bak5 as datetime )  <?1 and  model.wtbz=2   and  " + sql, TJgdm.class).setParameter(1,DateUtil.dayBefore(DateUtil.strToDate(DateUtil.dateToStr(new Date())), date)).getResultList();
            if (dms == null || dms.isEmpty()) {
                return 0;
            }
            return dms.size();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            ThamsEntityManagerHelper.closeEntityManager();
        }
    }

    public List<TSmrw> findByDate(User user) {
        log.info("finding all sql's data instances");
        if (user.getNeedScan() != null && !user.getNeedScan()) {
            return null;
        }
        String bzjgdm = user.getBzjgdm().trim();
        try {
            String sql = "";
            List<String> xzqhs = getXzqhs(bzjgdm);
            if (xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
                sql = " model.bzjgdm='" + bzjgdm + "' ";
            } else {
                sql = " model.bzjgdm in ('";
                for (String bzjg : xzqhs) {
                    sql += bzjg + "','";
                }
                sql = sql.substring(0, sql.lastIndexOf(",'"));
                sql += ") ";
            }
            if (InitSysParams.system.getSmqx() == null || InitSysParams.system.getSmqx() == 0)
                return null;
            int date = InitSysParams.system.getSmqx();
            date += InitSysParams.zrxzqhMap2.get(bzjgdm).getSmyq() == null ? 0 : InitSysParams.zrxzqhMap2.get(bzjgdm).getSmyq();
            date += user.getYqsj() == null ? 0 : user.getYqsj();
            Query query = getEntityManager().createQuery("select model from TSmrw  model where " + sql + " and (model.status=false or  model.status is null ) and   model.createTime <:date")
                    .setParameter("date", DateUtil.dayBefore(DateUtil.strToDate(DateUtil.dateToStr(new Date())), date));
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(TSmTaskDAO.class, re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

}