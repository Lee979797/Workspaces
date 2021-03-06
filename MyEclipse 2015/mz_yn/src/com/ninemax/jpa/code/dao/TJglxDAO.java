package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TJglx;
import com.ninemax.jpa.code.model.TNJglx;
import com.ninemax.jpa.code.model.TNNjjlx;
import com.ninemax.jpa.code.model.TNjjhy;
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
public class TJglxDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TJglxDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TJglx findById(String id) {
        log.info("finding Tsp instance with id: " + id);
        try {
            TJglx instance = getEntityManager().find(TJglx.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TJglx> findByProperty(String propertyName, final Object value) {
        log.info("finding Tsp instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TJglx model where model."
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
    public List<TJglx> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TJglx model order by model.dm";
            Query query = getEntityManager().createQuery(queryString);
            List<TJglx> jglxes = query.getResultList();
            getEntityManager().clear();
            return jglxes;
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TNJglx> findNAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TNJglx model order by model.dm";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TJglx> findbyhql(String hql) {
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

    public List<TJglx> getListPage(String mc, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {

        List<TJglx> array = new ArrayList<TJglx>();
        String sql = "select * from sc_jglx where 1=1 ";
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
                TJglx njjhy = new TJglx();
                njjhy.setDm(crs.getString("dm"));
                njjhy.setMc(crs.getString("mc"));
                array.add(njjhy);
            }
        } catch (Exception e) {
            log.error(e);
        }

        return array;
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
    
}