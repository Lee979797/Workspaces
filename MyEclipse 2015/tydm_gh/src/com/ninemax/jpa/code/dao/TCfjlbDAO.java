package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TCfjlb;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class TCfjlbDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TCfjlbDAO.class);

    public TCfjlb findById(Integer id) {
        return find(TCfjlb.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<TCfjlb> findByProperty(String propertyName, final Object value) {
        log.info("finding TCfjlb instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TCfjlb model where model."
                    + propertyName + "= :propertyValue";
            Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TCfjlb> findByPropertys(final Map<String, Object> map) {
        try {
            StringBuilder where = new StringBuilder("select model from TCfjlb model where ");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and")).toString();

                Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
                for (Map.Entry entry : map.entrySet()) {
                    query.setParameter((String) entry.getKey(), entry.getValue());
                }

                return query.getResultList();
            }
            return null;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TCfjlb> findAll() {
        log.info("finding all TCfjlb instances");
        try {
            final String queryString = "select model from TCfjlb model";
            Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TCfjlb> findbyhql(String hql) {
        log.info("finding all TCfjlb instances");
        try {
            Query query = EntityManagerHelper.getEntityManager().createQuery(hql);
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
            Query query = EntityManagerHelper.getEntityManager().createNativeQuery(sql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}