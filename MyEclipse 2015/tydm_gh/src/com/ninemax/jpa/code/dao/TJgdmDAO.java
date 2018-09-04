package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmBs;
import com.ninemax.jpa.code.model.vo.TjgdmVO;
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
public class TJgdmDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TJgdmDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TJgdm findById(String id) {
        return find(TJgdm.class, id);

    }

    @SuppressWarnings("unchecked")
    public List<TJgdm> findByProperty(String propertyName, final Object value) {
        log.info("finding Tjgdm instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TJgdm model where model."
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
    
    public List<TJgdmBs> findByPropertyBs(String propertyName, final Object value) {
    	log.info("finding Tjgdm instance with property: " + propertyName
    			+ ", value: " + value);
    	try {
    		final String queryString = "select model from TJgdmBs model where model."
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

    public boolean deleteById(String id) {
        boolean flag = true;
        EntityManager em = EntityManagerHelper.getEntityManager();
        em.clear();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            final String queryString = "delete t_jgdm where jgdm='" + id + "'";
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

    public List<TJgdm> findByPropertys(final Map<String, Object> map,String jglx) {
        try {
        	StringBuilder where=null;
        	if("1".equals(jglx)){
        		
        		 where = new StringBuilder("select model from TJgdm model where jglx='1' and");
        	}else{
        		where = new StringBuilder("select model from TJgdm model where");
        	}
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and"));

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
    public List<TJgdmBs> findByPropertyBs(final Map<String, Object> map,String jglx) {
        try {
        	StringBuilder where=null;
        
        		where = new StringBuilder("select model from TJgdmBs model where");
        	
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and"));

                Query query = CheckEntityManagerHelper.getEntityManager().createQuery(queryString);
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
    public List<TJgdm> findByPropertys(final Map<String, Object> map) {
    	try {
    		StringBuilder where=null;

    			where = new StringBuilder("select model from TJgdm model where");
    		if (map != null && !map.isEmpty()) {
    			for (Map.Entry entry : map.entrySet()) {
    				where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
    			}
    			final String queryString = where.substring(0, where.lastIndexOf("and"));
    			
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
    public List<TJgdm> findAll() {
        log.info("finding all Tjgdm instances");
        try {
            final String queryString = "select model from TJgdm model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TJgdm> findbyhql(String hql) {
        log.info("finding all Tjgdm instances");
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

    public List<Object[]>  listTjgdm(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List<Object> params) {
        log.info("finding TJgdmSave instances");
        Query query = null;
		try {
            if(pageno==0){
                pageno = 1;
            }
			query = getEntityManager().createNativeQuery(jql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			setQueryParams(query, params);
			pageComponent.setNativeTotalSize(jql.substring(jql.indexOf("from"), jql.indexOf("order")), params);
			pageComponent.setPageSize(rowNumsView);
			pageComponent.setTotalPages();
			pageComponent.setLastPage();
			pageComponent.setStartIndex(pageno);
			pageComponent.setCurrentPage(pageno);
            return query.getResultList();
		} catch (Exception re) {
			log.error("find all failed", re);
		}finally {
            EntityManagerHelper.closeEntityManager();
        }
       return null;
    }

    public List<TjgdmVO> listCertTjgdm(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List<Object> params) {
        log.info("finding TJgdmSave instances");
		Query query = null;
        try {
            if(pageno==0){
                pageno = 1;
            }
			query = getEntityManager().createQuery(jql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			setQueryParams(query, params);
			pageComponent.setTotalSize(jql.substring(jql.indexOf("from"),jql.indexOf("order")),params);
			pageComponent.setPageSize(rowNumsView);
			pageComponent.setTotalPages();
			pageComponent.setLastPage();

			pageComponent.setStartIndex(pageno);
			pageComponent.setCurrentPage(pageno);
            return query.getResultList();
        } catch (Exception re) {
			log.error("find all failed", re);
		} finally {
            EntityManagerHelper.closeEntityManager();
        }
       return null;
    }
}