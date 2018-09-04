package com.ninemax.jpa.system.dao;


import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.PoliticalLandscape;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class PoliticalLandscapeDAO extends BaseDao  {
	private static Logger log = Logger.getLogger(PoliticalLandscapeDAO.class);
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public PoliticalLandscape findById( Integer id) {
    				log.info("finding PoliticalLandscape instance with id: " + id);
	        try {
            PoliticalLandscape instance = getEntityManager().find(PoliticalLandscape.class, id);
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
	 * Find all PoliticalLandscape entities with a specific property value.  
	 
	  @param propertyName the name of the PoliticalLandscape property to query
	  @param value the property value to match
	  	  @return List<PoliticalLandscape> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<PoliticalLandscape> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding PoliticalLandscape instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from PoliticalLandscape model where model." 
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
	 * Find all PoliticalLandscape entities.
	  	  @return List<PoliticalLandscape> all PoliticalLandscape entities
	 */
	@SuppressWarnings("unchecked")
	public List<PoliticalLandscape> findAll(
		) {
					log.info("finding all PoliticalLandscape instances");
			try {
			final String queryString = "select model from PoliticalLandscape model";
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
	
}