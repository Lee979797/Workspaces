package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.Portfolio_log;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.List;


public class Portfolio_logDAO extends BaseDao  {


	private static Logger log = Logger.getLogger(Portfolio_logDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public Portfolio_log findById( String id) {
    				log.info("finding Portfolio instance with id: " + id);
	        try {
            Portfolio_log instance = getEntityManager().find(Portfolio_log.class, id);
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
	 * Find all Portfolio entities with a specific property value.  
	 
	  @param propertyName the name of the Portfolio property to query
	  @param value the property value to match
	  	  @return List<Portfolio> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Portfolio_log> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding Portfolio instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from Portfolio model where model." 
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
	 * Find all Portfolio entities.
	  	  @return List<Portfolio> all Portfolio entities
	 */
	@SuppressWarnings("unchecked")
	public List<Portfolio_log> findAll(
		) {
					log.info("finding all Portfolio instances");
			try {
			final String queryString = "select model from Portfolio model";
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
	
	
	public List<Portfolio_log> findPageList(String searchField, String searchValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent,String bzd)  throws ParseException {
		log.info("finding all Portfolio_log instances");
		
		
		try {
			String queryString = "select model from Portfolio_log model, User user where 1=1 ";
			
			String sdate = startDate+" 00:00:00";
			if(!clsStringTool.isEmpty(startDate) ){
				queryString += " and model.operdate >= ? ";
			}
			String edate = endDate+" 23:59:59";
			if(!clsStringTool.isEmpty(endDate) ){
				queryString += " and model.operdate <= ? ";
			}
			
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" like '%"+searchValue+"%'";
			}
			queryString += " and user.userId = model.userid ";
			if(bzd.endsWith("0000")){
			    queryString += " and user.userProvince like " + (bzd.length() == 6 ?  "'"+bzd.substring(0, 2)+"%'":"");
			}else if(bzd.endsWith("00")){
				queryString += " and user.userProvince like " + (bzd.length() == 6 ? "'"+bzd.substring(0, 4)+"%'":"");
			}else{
				queryString += " and user.userProvince =" + "'"+bzd+ "'";
			}

			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.operdate desc";
			}
			log.info(queryString);
			Query query = getEntityManager().createQuery(queryString+orderByContent);
			query.setFirstResult(pageSize * (pageNo - 1));
			query.setMaxResults(pageSize);
			Object params[]={sdate,edate};
			setQueryParams(query,params);
			try {
				int fromIndex = queryString.indexOf(" from ");
				log.info(queryString.substring(fromIndex));
				pageComponent.setTotalSize(queryString.substring(fromIndex),params);
				pageComponent.setPageSize(pageSize);
				pageComponent.setTotalPages();
				pageComponent.setLastPage();
				pageComponent.setStartIndex(pageNo);
				pageComponent.setCurrentPage(pageNo);
			} catch (Exception e) {
				log.error("find all failed",  e);
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