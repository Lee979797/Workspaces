package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.Pmtranslate;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class PmtranslateDAO extends BaseDao  {


	private static Logger log = Logger.getLogger(PmtranslateDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public Pmtranslate findById( Integer id) {
    				log.info("finding Pmtranslate instance with id: " + id);
	        try {
            Pmtranslate instance = getEntityManager().find(Pmtranslate.class, id);
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
	 * Find all Pmtranslate entities with a specific property value.  
	 
	  @param propertyName the name of the Pmtranslate property to query
	  @param value the property value to match
	  	  @return List<Pmtranslate> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Pmtranslate> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding Pmtranslate instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from Pmtranslate model where model." 
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
	 * Find all Pmtranslate entities.
	  	  @return List<Pmtranslate> all Pmtranslate entities
	 */
	@SuppressWarnings("unchecked")
	public List<Pmtranslate> findAll(
		) {
					log.info("finding all Pmtranslate instances");
			try {
			final String queryString = "select model from Pmtranslate model";
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