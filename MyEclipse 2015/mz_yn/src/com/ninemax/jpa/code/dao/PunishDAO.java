package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TCfjlb;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Liuzy
 *
 */
public class PunishDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger("com.ninemax.jpa.code.dao.PunishDAO");

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TCfjlb findById(Integer id) {
        log.info("finding TCfjlb instance with id: " + id);
        try {
            TCfjlb instance = getEntityManager().find(TCfjlb.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            log.info("closing TCfjlb instance with id: " + id);
			EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TCfjlb> findByProperty(String propertyName, final Object value) {
        log.info("finding TCfjlb instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TCfjlb model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            log.info("closing TCfjlb instance with property: " + propertyName
                    + ", value: " + value);
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
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            log.info("closing all TCfjlb instances");
			EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TCfjlb> findListbyhql(String jql,Integer pageno,Integer rowNumsView,clsPageComponent pageComponent,List params) throws Exception {
        log.info("finding all TCfjlb instances");
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
        } finally {
            log.info("closing all TCfjlb instances");
			EntityManagerHelper.closeEntityManager();
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