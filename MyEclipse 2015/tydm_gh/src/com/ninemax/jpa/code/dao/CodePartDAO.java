package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.Mdsource;
import com.ninemax.jpa.code.model.QTMdsource;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Liuzy
 */
public class CodePartDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger("com.ninemax.jpa.code.dao.CodePartDAO");

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public Mdsource findById(Integer id) {
        log.info("finding Mdsource instance with id: " + id);
        try {
            Mdsource instance = getEntityManager().find(Mdsource.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            log.info("closing Mdsource instance with id: " + id);
			EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Mdsource> findByProperty(String propertyName, final Object value) {
        log.info("finding Mdsource instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from Mdsource model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            log.info("closing Mdsource instance with property: " + propertyName
                    + ", value: " + value);
			EntityManagerHelper.closeEntityManager();
        }
    }

    public List<QTMdsource> findQTMdByProperty(String propertyName, final Object value) {
        log.info("finding Mdsource instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from QTMdsource model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            log.info("closing Mdsource instance with property: " + propertyName
                    + ", value: " + value);
			EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Mdsource> findAll() {
        log.info("finding all Mdsource instances");
        try {
            final String queryString = "select model from Mdsource model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            log.info("closing all Mdsource instances");
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<Mdsource> findMdbyhql(String hql) {
        log.info("finding all Mdsource instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            log.info("closing all Mdsource instances" + hql);
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<QTMdsource> findQTMdByHql(String hql) {
        log.info("finding all Mdsource instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            log.info("closing all Mdsource instances");
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List findMdbyjql(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List params) throws Exception {
        log.info("finding Mdsource instances");
        try {
            Query query = getEntityManager().createQuery(jql);
            query.setFirstResult(rowNumsView * (pageno==0?0:pageno - 1));
            query.setMaxResults(rowNumsView);
            setQueryParams(query, params);

            int length = jql.indexOf("order");
            length = length > 0 ? length : jql.length();
            pageComponent.setTotalSize(jql.substring(0,length), params);
            pageComponent.setPageSize(rowNumsView);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();

            pageComponent.setStartIndex(pageno);
            pageComponent.setCurrentPage(pageno);
            return query.getResultList();
        } catch (Exception re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List findMdbysql(String sql) {
        log.info("finding all sql's data instances");
        try {
            Query query = getEntityManager().createNativeQuery(sql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            log.info("closing all source");
			EntityManagerHelper.closeEntityManager();
        }
    }

}