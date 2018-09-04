package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TJjlx;
import com.ninemax.jpa.code.model.TNNjjlx;
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
public class TJjlxDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TJjlxDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TJjlx findById(String id) {
        log.info("finding Tsp instance with id: " + id);
        try {
            TJjlx instance = getEntityManager().find(TJjlx.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TJjlx> findByProperty(String propertyName, final Object value) {
        log.info("finding Tsp instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TJjlx model where model."
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
    public List<TJjlx> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TJjlx model order by model.dm";
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
    public List<TNNjjlx> findAlljjlx2011() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TNNjjlx model order by model.dm";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TJjlx> findbyhql(String hql) {
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

    public List<TJjlx> getListPage(String mc, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {
        List array = new ArrayList();
        String sql = "select * from t_jjlx where 1=1";
        if (!clsStringTool.isEmpty(mc)) {
            sql += " and dm like '%" + mc + "%' or mc like '%" + mc + "%'";
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
                TJjlx jjlx = new TJjlx();
                jjlx.setDm(crs.getString("dm"));
                jjlx.setMc(crs.getString("mc"));
                array.add(jjlx);
            }
        } catch (Exception e) {
            log.error(e);
        }

        return array;
    }
  
}