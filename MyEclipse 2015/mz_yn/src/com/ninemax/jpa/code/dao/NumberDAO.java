package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TZsbhb;
import com.ninemax.jpa.code.model.TZsbhsource;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
/**
 *
 * @author Liuzy
 *
 */
public class NumberDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger("com.ninemax.jpa.code.dao.NumberDAO");

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TZsbhsource findById(Integer id) {
        log.info("finding TZsbhsource instance with id: " + id);
        try {
            TZsbhsource instance = getEntityManager().find(TZsbhsource.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TZsbhsource> findByProperty(String propertyName, final Object value) {
        log.info("finding TZsbhsource instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TZsbhsource model where model."
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
    public List<TZsbhsource> findAll() {
        log.info("finding all TZsbhsource instances");
        try {
            final String queryString = "select model from TZsbhsource model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }  finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TZsbhsource> findbyhql(String hql) {
        log.info("finding all TZsbhsource instances");
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

    public List<TZsbhb> findZsbyhql(String jql,Integer pageno,Integer rowNumsView,clsPageComponent pageComponent,List params) throws Exception {
        log.info("finding TZsbhb instances");
        try {
            Query query = getEntityManager().createQuery(jql);
            query.setFirstResult(rowNumsView*(pageno-1));
            query.setMaxResults(rowNumsView);
            setQueryParams(query,params);

            pageComponent.setTotalSize(jql,params);
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

    public boolean save(Object entity) {
        boolean flag = true;
        try {
            getEntityManager().persist(entity);
        } catch (Exception e) {
            flag = false;
            log.error("error", e);
            log.error(e);
            return flag;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return flag;
    }

    public List findbysql(String sql) {
        log.info("finding all sql's data instances");
        try {
            Query query = getEntityManager().createNativeQuery(sql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}