package com.ninemax.jpa.collection.dao;
// default package

import com.ninemax.jpa.collection.model.CheckControl;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;



public class CheckControlDAO  extends BaseDao  {

	private static Logger log = Logger.getLogger("com.ninemax.jpa.collection.dao.CheckControlDAO");
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	    
    public CheckControl findById( Integer id) {
    				log.info("finding CheckControl instance with id: " + id);
	        try {
            CheckControl instance = getEntityManager().find(CheckControl.class, id);
            return instance;
        } catch (RuntimeException re) {
        		log.error("find failed", re);
	            throw re;
        }
		finally
		{
			log.info("closing CheckControl instance with id: " + id);
			EntityManagerHelper.closeEntityManager();
		}
    }    
    

    @SuppressWarnings("unchecked")
    public List<CheckControl> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding CheckControl instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from CheckControl model where model." 
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
			log.info("closing CheckControl instance with property: " + propertyName + ", value: " + value);
			EntityManagerHelper.closeEntityManager();
		}
	}			
	

	@SuppressWarnings("unchecked")
	public List<CheckControl> findAll(
		) {
					log.info("finding all CheckControl instances");
			try {
			final String queryString = "select model from CheckControl model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find all failed", re);
				throw re;
		}
		finally
		{
			log.info("closing all CheckControl instances");
			EntityManagerHelper.closeEntityManager();
		}
	}
	
}