package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TNNJjhy;
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
public class TNjjhyDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TNjjhyDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TNjjhy findById(String id) {
        return find(TNjjhy.class, id);
    }

    public TNNJjhy findByDM(String dm) {
        log.info("finding Tsp instance with id: " + dm);
        try {
            TNNJjhy instance = getEntityManager().find(TNNJjhy.class, dm);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TNjjhy> findByProperty(String propertyName, final Object value) {
        log.info("finding Tsp instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TNjjhy model where model."
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
    public List<TNjjhy> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TNjjhy model where length(model.dm) = 5  order by model.dm";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TNjjhy> findBigAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TNjjhy model order by model.dm";
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
    public List<TNNJjhy> find2k1All() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TNNJjhy model where length(model.dm) = 5  order by model.dm";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public static void main(String[] args) {
        new TNjjhyDAO().findAll();
    }

    public List<TNjjhy> findbyhql(String hql) {
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

    public List<TNjjhy> getListPage(String mc, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {

        List array = new ArrayList();
        String sql = "select * from t_njjhy where  len(dm) = 5 ";
        if (!clsStringTool.isEmpty(mc)) {
            sql += " and (dm like '%" + mc + "%' or mc like '%" + mc + "%')";
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
                TNjjhy njjhy = new TNjjhy();
                njjhy.setDm(crs.getString("dm"));
                njjhy.setMc(crs.getString("mc"));
                array.add(njjhy);
            }
        } catch (Exception e) {
            log.error(e);
        }

        return array;
    }

    /**
     * 获取2011版经济行业列表
     *
     * @param mc
     * @param pageSize
     * @param pageNo
     * @param pageComponent
     * @return
     */
    public List<TNNJjhy> getTKOListPage(String mc, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {

        List array = new ArrayList();
        String sql = "select * from sc_jjhy where  len(dm) = 5";
        if (!clsStringTool.isEmpty(mc)) {
            sql += " and (dm like '%" + mc + "%' or mc like '%" + mc + "%')";
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
                TNNJjhy njjhy = new TNNJjhy();
                njjhy.setDm(crs.getString("dm"));
                njjhy.setMc(crs.getString("mc"));
                array.add(njjhy);
            }
        } catch (Exception e) {
            log.error(e);
        }

        return array;
    }
}