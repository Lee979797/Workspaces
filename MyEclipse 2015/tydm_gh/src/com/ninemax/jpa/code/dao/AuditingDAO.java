package com.ninemax.jpa.code.dao;

// default package

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
public class AuditingDAO extends BaseDao {

	private static Logger log = Logger
			.getLogger("com.ninemax.jpa.code.dao.AuditingDAO");

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	private EntityManager getEntityManager(int i) {
		if(i==1)
			return EntityManagerHelper.getEntityManager();

		return EntityManagerHelper.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List findListByjql(String jql) {
		log.info("finding all Object instances");
		try {
			Query query = getEntityManager().createQuery(jql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public Object findObjectByjql(String sql) {
		log.info("finding all Object instances");
		try {
			Query query = getEntityManager().createNativeQuery(sql);
			return query.getResultList().get(0);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public <T> T findObjectById(Class<T> entityClass,Object primaryKey,int flag) {
		log.info("finding all Object instances");
		try {
			return getEntityManager(flag).find(entityClass, primaryKey);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public <T> T findObjectById(Class<T> entityClass,String jql,int flag) {
	        try {
	           
	            Query query = getEntityManager().createQuery(jql);
	            return (T) query.getResultList().get(0);
	        } catch (RuntimeException re) {
	            log.error("find by property name failed", re);
	            throw re;
	        }
	}

	
	public int executeSql(String sql,int flag) {
		log.info("execute hql");
		try {
			EntityManager em = getEntityManager(flag);
			
			return em.createNativeQuery(sql).executeUpdate();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	public List findPageListbyjql(String jql,Integer pageno,Integer rowNumsView,clsPageComponent pageComponent,List params,int flag) throws Exception {
		log.info("finding all Object instances");
		try {
			Query query = getEntityManager(flag).createQuery(jql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			
			setQueryParams(query,params);
			
			pageComponent.setTotalSize(jql,params,flag);
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
	
	public List findObjBysql(String sql) {
		log.info("finding all sql's data instances");
		try {
			Query query = getEntityManager().createNativeQuery(sql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}
	
}