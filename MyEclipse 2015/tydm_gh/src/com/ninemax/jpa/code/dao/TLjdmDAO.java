package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TLjdm;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-11
 * Time: ÉÏÎç11:13
 */
public class TLjdmDAO extends BaseDao {
    private static Logger log = Logger
            .getLogger(TLjdmDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TLjdm findById(String id) {
        log.info("finding Tczjl instance with id: " + id);
        try {
            TLjdm instance = getEntityManager().find(TLjdm.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        }  finally {
            EntityManagerHelper.closeEntityManager();
        }
    }



    @SuppressWarnings("unchecked")
    public List<TLjdm> findByProperty(String propertyName, final Object value) {
        log.info("finding Tczjl instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TLjdm model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }   finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TLjdm> findAll() {
        log.info("finding all TLjdm instances");
        try {
            final String queryString = "select model from TLjdm model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }     finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TLjdm> findbyhql(String hql) {
        log.info("finding all TLjdm instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }    finally {
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
        }      finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}
