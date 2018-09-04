package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.Forbidword;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.List;


public class ForbidwordDAO extends BaseDao {
	private static Logger log = Logger.getLogger(ForbidwordDAO.class);
	//property constants
	public static final String FORBIDWORD = "forbidWord";


	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public Forbidword findById( Integer id) {
    				log.info("finding Forbidword instance with id: " + id);
	        try {
            Forbidword instance = getEntityManager().find(Forbidword.class, id);
            return instance;
        } catch (RuntimeException re) {
        				log.error("find failed", re);
	            throw re;
        }finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
    }    
    

/**
	 * Find all Forbidword entities with a specific property value.  
	 
	  @param propertyName the name of the Forbidword property to query
	  @param value the property value to match
	  	  @return List<Forbidword> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Forbidword> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding Forbidword instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from Forbidword model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find by property name failed", re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}
    
    public List<Forbidword> getForBidIDByWord(Object usergroupMemo
	) {
		return findByProperty(FORBIDWORD, usergroupMemo
		);
	}
	
	/**
	 * Find all Forbidword entities.
	  	  @return List<Forbidword> all Forbidword entities
	 */
	@SuppressWarnings("unchecked")
	public List<Forbidword> findAll(
		) {
					log.info("finding all Forbidword instances");
			try {
			final String queryString = "select model from Forbidword model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find all failed", re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}
	
	
	
	public List<Forbidword> findPageList(String searchField, String searchValue,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all Forbidword instances");
		try {
			String queryString = "from Forbidword model where 1=1";
			
			
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" like '%"+searchValue+"%'";
			}
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.forbidId desc";
			}
			Query query = getEntityManager().createQuery(queryString+orderByContent);
			query.setFirstResult(pageSize*(pageNo-1));
			query.setMaxResults(pageSize);
			Object params[]={};
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
			log.error("find all failed", re);
			throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}
	
}