package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.ScDzzlx;
import com.ninemax.jpa.code.model.ScMz;
import com.ninemax.jpa.code.model.ScWjdyy;
import com.ninemax.jpa.code.model.ScZw;
import com.ninemax.jpa.code.model.ScZzmm;
import com.ninemax.jpa.code.model.TGj;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuzy
 */
public class TGjDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TGjDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TGj findById(String id) {
        log.info("finding Tsp instance with id: " + id);
        try {
            TGj instance = getEntityManager().find(TGj.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TGj> findByProperty(String propertyName, final Object value) {
        log.info("finding Tsp instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TGj model where model."
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

    @SuppressWarnings("unchecked")
    public List<TGj> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TGj model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    @SuppressWarnings("unchecked")
    public List<ScZw> findAllZw() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from ScZw model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    @SuppressWarnings("unchecked")
    public List<ScMz> findAllMz() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from ScMz model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    public List<ScZzmm> findAllZzmm() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from ScZzmm model order by dm asc";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    public List<ScDzzlx> findAllDzzlx() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from ScDzzlx model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    public List<ScWjdyy> findAllWjdyy() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from ScWjdyy model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    public List<TGj> findbyhql(String hql) {
        log.info("finding all Tsp instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }


    public List findbysql(String sql) {
        log.info("finding all sql's data instances");
        try {
            Query query = getEntityManager().createNativeQuery(sql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TGj> getListPage(String userInput, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {
        List array = new ArrayList();
        String sql = "select * from sc_gj where 1=1 ";
        if (!clsStringTool.isEmpty(userInput)) {
            sql += " and dm like '%" + userInput + "%' or mc like '%" + userInput + "%'";
        }
        String orderByContent = "dm asc";

        try {
            pageComponent.setTotalSize(sql);
            pageComponent.setPageSize(pageSize);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();
            pageComponent.setStartIndex(pageNo);
            pageComponent.setCurrentPage(pageNo);
            pageComponent.setOrderByContent(orderByContent);
            CachedRowSet crs = pageComponent.getResultList(sql);

            while (crs.next()) {
                TGj gj = new TGj();
                gj.setDm(crs.getString("dm"));
                gj.setMc(crs.getString("mc"));
                array.add(gj);
            }
        } catch (Exception e) {
            log.error(e);
        }

        return array;
    }
}