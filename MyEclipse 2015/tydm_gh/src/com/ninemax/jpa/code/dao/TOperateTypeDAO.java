package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TOperateType;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-8
 * Time: ÏÂÎç2:07
 */
public class TOperateTypeDAO {

    private static Logger log = Logger
            .getLogger(TCzjlDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TOperateType findById(String id) {
        log.info("finding Tczjl instance with id: " + id);
        try {
            TOperateType instance = getEntityManager().find(TOperateType.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TOperateType> findByProperty(String propertyName, final Object value) {
        log.info("finding Tczjl instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TOperateType model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TOperateType> findAll() {
        log.info("finding all TOperateType instances");
        try {
            String queryString = "select model from TOperateType model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TOperateType> findbyhql(String hql) {
        log.info("finding all TOperateType instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }  finally {
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
        }  finally {
            EntityManagerHelper.closeEntityManager();
        }
    }


}
