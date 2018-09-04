package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.Gtgsh;
import com.ninemax.jpa.code.model.Qiye;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class GsDAO extends BaseDao {

    private static Logger log = Logger.getLogger(GsDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    private void closeEntityManager() {
        EntityManagerHelper.closeEntityManager();
    }

    public Qiye findById(String id) {
        log.info("finding Qiye instance with id: " + id);
        try {
            Qiye instance = getEntityManager().find(Qiye.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }

    public Gtgsh findGtById(String id) {
        log.info("finding Gtgsh instance with id: " + id);
        try {
            Gtgsh instance = getEntityManager().find(Gtgsh.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Qiye> findByProperty(String propertyName, final Object value) {
        log.info("finding Qiye instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from Qiye model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }

    public List<Qiye> findByPropertys(final Map<String, Object> map) {
        try {
            StringBuilder where = new StringBuilder("select model from Qiye model where ");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and"));
                Query query = getEntityManager().createQuery(queryString);
                for (Map.Entry entry : map.entrySet()) {
                    query.setParameter((String) entry.getKey(), entry.getValue());
                }

                return query.getResultList();
            }
            return null;
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Qiye> findAll() {
        log.info("finding all Qiye instances");
        try {
            final String queryString = "select model from Qiye model where model.cdqzt='正常' ";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }

    public List<Qiye> findbyhql(String hql) {
        log.info("finding all Qiye instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }


    public List findbysql(String sql) {
        log.info("finding all sql's data instances");
        try {
            Query query = getEntityManager().createNativeQuery(sql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }

    public List<Qiye> findByZch(String zch) {
        try {
            //TODO 修改sql
            //String queryString = "select model from Qiye model where model.cdqzt='正常' and model.czch =?1 ";
            log.info("select qy:zch|"+zch+"|");
            String queryString = "select model from Qiye model where  model.czch =?1 ";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter(1, zch);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }

    public List<Gtgsh> findGtByZch(String zch) {
        try {
            String queryString = "select model from Gtgsh model where model.cdqzt='正常' and  model.czch =?1 ";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter(1, zch);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(GsDAO.class, re);
            throw re;
        } finally {
            closeEntityManager();
        }
    }

    public List<Qiye> listQiyeList(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List<Object> params) {
        log.info("finding listQiyeList");
        Query query = null;
        try {
            if (pageno == 0) {
                pageno = 1;
            }
            query = getEntityManager().createQuery(jql);
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            setQueryParams(query, params);
            pageComponent.setTotalSize(jql.substring(0, jql.indexOf("order")), params);
            pageComponent.setPageSize(rowNumsView);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();
            pageComponent.setStartIndex(pageno);
            pageComponent.setCurrentPage(pageno);

        } catch (Exception re) {
            log.error(GsDAO.class, re);
        }finally {
            closeEntityManager();
        }
        return query.getResultList();
    }
}