package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.ScBzjgdm;
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
public class ScBzjgdmDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(ScBzjgdmDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public ScBzjgdm findById(String id) {
        log.info("finding Tsp instance with id: " + id);
        try {
            ScBzjgdm instance = getEntityManager().find(ScBzjgdm.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            getEntityManager().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<ScBzjgdm> findByProperty(String propertyName, final Object value) {
        log.info("finding Tsp instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from ScBzjgdm model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            getEntityManager().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<ScBzjgdm> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from ScBzjgdm model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager(); 
        }
    }

    public List<ScBzjgdm> findbyhql(String hql) {
        log.info("finding all Tsp instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            getEntityManager().close();
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
            getEntityManager().close();
        }
    }

    public List<ScBzjgdm> getListPage(String userInput, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {
        List array = new ArrayList();
        String sql = "select * from sc_bzjgdm where 1=1 ";
        if (!clsStringTool.isEmpty(userInput)) {
            sql += " and dm like '" + userInput + "%' or mc like '%" + userInput + "%'";
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
                ScBzjgdm xzqh = new ScBzjgdm();
                xzqh.setDm(crs.getString("dm"));
                xzqh.setMc(crs.getString("mc"));
                array.add(xzqh);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return array;
    }
}