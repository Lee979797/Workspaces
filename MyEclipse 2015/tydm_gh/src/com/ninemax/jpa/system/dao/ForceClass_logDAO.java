package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.ForceClass_log;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ForceClass_logDAO extends BaseDao  {


	private static Logger log = Logger.getLogger(ForceClass_logDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public ForceClass_log findById( String id) {
    				log.info("finding ForceClass instance with id: " + id);
	        try {
            ForceClass_log instance = getEntityManager().find(ForceClass_log.class, id);
            return instance;
        } catch (RuntimeException re) {
        				log.error("find failed",  re);
	            throw re;
        }finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
    }    
    

/**
	 * Find all ForceClass entities with a specific property value.  
	 
	  @param propertyName the name of the ForceClass property to query
	  @param value the property value to match
	  	  @return List<ForceClass> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<ForceClass_log> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding ForceClass instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from ForceClass model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find by property name failed",  re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}			
	
	/**
	 * Find all ForceClass entities.
	  	  @return List<ForceClass> all ForceClass entities
	 */
	@SuppressWarnings("unchecked")
	public List<ForceClass_log> findAll(
		) {
					log.info("finding all ForceClass instances");
			try {
			final String queryString = "select model from ForceClass model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find all failed",  re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}
	
	public List<ForceClass_log> findPageList(String searchField, String searchValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all ForceClass_log instances");
		try {
			String queryString = "from ForceClass_log model where 1=1";
			
		//	queryString += " to_char(model.operdate,'YYYY-MM-DD HH24:mi:ss') > '"+startDate+" 00:00:00' and to_char(model.operdate,'YYYY-MM-DD HH24:mi:ss') < '"+endDate+" 23:59:59' ";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date sdate = sdf.parse(startDate+" 00:00:00");
			if(!clsStringTool.isEmpty(startDate) ){
				queryString += " and model.operDate >= ? ";
			}
			Date edate = sdf.parse(endDate+" 23:59:59");
			if(!clsStringTool.isEmpty(endDate) ){
				queryString += " and model.operDate <= ? ";
			}
			
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" like '%"+searchValue+"%'";
			}
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.operDate desc";
			}
			Query query = getEntityManager().createQuery(queryString+orderByContent);
			query.setFirstResult(pageSize*(pageNo-1));
			query.setMaxResults(pageSize);
			Object params[]={sdate,edate};
			setQueryParams(query,params);
			try {
				pageComponent.setTotalSize(queryString,params);
				pageComponent.setPageSize(pageSize);
				pageComponent.setTotalPages();
				pageComponent.setLastPage();
				pageComponent.setStartIndex(pageNo);
				pageComponent.setCurrentPage(pageNo);
			} catch (Exception e) {
				log.error("error", e);
				throw new RuntimeException(e.getMessage(),e);
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed",  re);
			throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}
	
}