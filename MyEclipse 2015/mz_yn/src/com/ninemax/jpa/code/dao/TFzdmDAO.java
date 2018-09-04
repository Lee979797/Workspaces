package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TFzdm;
import com.ninemax.jpa.code.model.TFzdmBs;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class TFzdmDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TFzdmDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TFzdm findById(String id) {
        log.info("finding Tfzdm instance with id: " + id);
        try {
            TFzdm instance = getEntityManager().find(TFzdm.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public boolean deleteById(String id) {
        boolean flag = true;
        EntityManager em = EntityManagerHelper.getEntityManager();
        em.clear();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            final String queryString = "delete t_fzdm where jgdm='" + id + "'";
            em.createNativeQuery(queryString).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            flag = false;
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error("error", e);
            log.error(e);
            return flag;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    public List<TFzdm> findByProperty(String propertyName, final Object value) {
        log.info("finding Tfzdm instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TFzdm model where model."
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

    
    /**
     * ≤È—ØBSø‚
     * LP
     * 2016-4-6
     * @param propertyName
     * @param value
     * @return
     * Version @1.0
     */
    public List<TFzdmBs> findByPropertyBs(String propertyName, final Object value) {
    	log.info("finding Tfzdm instance with property: " + propertyName
    			+ ", value: " + value);
    	try {
    		final String queryString = "select model from TFzdmBs model where model."
    			+ propertyName + "= :propertyValue";
    		Query query = CheckEntityManagerHelper.getEntityManager().createQuery(queryString);
    		query.setParameter("propertyValue", value);
    		return query.getResultList();
    	} catch (RuntimeException re) {
    		log.error("find by property name failed", re);
    		throw re;
    	} finally {
    		CheckEntityManagerHelper.closeEntityManager();
    	}
    }
    

    public List<TFzdm> findByPropertys(final Map<String, Object> map,String jglx) {
        try {
        	StringBuilder where=null;
        		if("1".equals(jglx)){
        			
        			where = new StringBuilder("select model from TFzdm model where jglx='1' and");
        		}else{
        			where = new StringBuilder("select model from TFzdm model where");
        		}
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
            log.error("find by findByPropertys name failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    public List<TFzdmBs> findByPropertyBs(final Map<String, Object> map,String jglx) {
        try {
        	StringBuilder where=null;
        
        			
        	
        			where = new StringBuilder("select model from TFzdmBs model where");
        		
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and")).toString();
                Query query = CheckEntityManagerHelper.getEntityManager().createQuery(queryString);
                for (Map.Entry entry : map.entrySet()) {
                    query.setParameter((String) entry.getKey(), entry.getValue());
                }

                return query.getResultList();
            }
            return null;
        } catch (RuntimeException re) {
            log.error("find by findByPropertys name failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    @SuppressWarnings("unchecked")
    public List<TFzdm> findAll() {
        log.info("finding all Tfzdm instances");
        try {
            final String queryString = "select model from TFzdm model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TFzdm> findbyhql(String hql) {
        log.info("finding all Tfzdm instances");
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

    public List<TFzdm> findByJgmcAndZch(String jgmc, String zch) {
        try {
            String jpql = "select model from TFzdm model where model.jgmc=:jgmc and model.zch =:zch";
            Query query = getEntityManager().createQuery(jpql);
            query.setParameter("jgmc", jgmc);
            query.setParameter("zch", zch);
            return  query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }  finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TFzdm> listFzTjgdm(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List<Object> params) {
        log.info("finding listQzTjgdm");
        Query query = null;
		try {
            if(pageno==0){
                pageno = 1;
            }
			query = getEntityManager().createQuery(jql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			setQueryParams(query, params);
			pageComponent.setTotalSize(jql.substring(0,jql.indexOf("order")),params);
			pageComponent.setPageSize(rowNumsView);
			pageComponent.setTotalPages();
			pageComponent.setLastPage();
			pageComponent.setStartIndex(pageno);
			pageComponent.setCurrentPage(pageno);

		} catch (Exception re) {
			log.error("find all failed", re);
		}
        return query.getResultList();
    }
}