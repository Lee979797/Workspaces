package com.ninemax.jpa.collection.dao;


import com.ninemax.jpa.collection.model.Fields;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;



public class FieldsDAO extends BaseDao {

	private static Logger log = Logger.getLogger(FieldsDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	

    public Fields findById( String id) {
    				log.info("finding Fields instance with id: " + id);
	        try {
            Fields instance = getEntityManager().find(Fields.class, id);
            return instance;
        } catch (RuntimeException re) {
        				log.error("find failed", re);
	            throw re;
        }
		finally
		{
			log.info("closing Fields instance with id: " + id);
			EntityManagerHelper.closeEntityManager();
		}
    }    
    

    @SuppressWarnings("unchecked")
    public List<Fields> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding Fields instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from Fields model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find by property name failed", re);
				throw re;
		}
		finally
		{
			log.info("closing Fields instance with property: " + propertyName + ", value: " + value);
			EntityManagerHelper.closeEntityManager();
		}
	}			
	

	@SuppressWarnings("unchecked")
	public List<Fields> findAll(
		) {
					log.info("finding all Fields instances");
			try {
			final String queryString = "select model from Fields model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find all failed", re);
				throw re;
		}
		finally
		{
			log.info("closing all Fields instances");
			EntityManagerHelper.closeEntityManager();
		}
	}
	
}