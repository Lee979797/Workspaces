package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.FieldType;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class FieldTypeDAO  extends BaseDao{

	private static Logger log = Logger.getLogger(FieldTypeDAO.class);
	public static final String FIELD_TYPE_NAME = "fieldTypeName";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
    
    public FieldType findById( String id) {
    				log.info("finding FieldType instance with id: " + id);
	        try {
            FieldType instance = getEntityManager().find(FieldType.class, id);
            return instance;
        } catch (RuntimeException re) {
        				log.error("find failed",  re);
	            throw re;
        }
        finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
    }    
    

    @SuppressWarnings("unchecked")
    public List<FieldType> findByProperty(String propertyName, final Object value
        , final int...rowStartIdxAndCount
        ) {
    				log.info("finding FieldType instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from FieldType model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {	
						int rowStartIdx = Math.max(0,rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}
		
						if (rowStartIdxAndCount.length > 1) {
					    	int rowCount = Math.max(0,rowStartIdxAndCount[1]);
					    	if (rowCount > 0) {
					    		query.setMaxResults(rowCount);    
					    	}
						}
					}										
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find by property name failed",  re);
				throw re;
		}
		finally
		{
			EntityManagerHelper.closeEntityManager();
		}
	}			
	public List<FieldType> findByFieldTypeName(Object fieldTypeName
	, int...rowStartIdxAndCount
	) {
		return findByProperty(FIELD_TYPE_NAME, fieldTypeName
	, rowStartIdxAndCount
		);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<FieldType> findAll(
		final int...rowStartIdxAndCount
		) {
					log.info("finding all FieldType instances");
			try {
			final String queryString = "select model from FieldType model";
								Query query = getEntityManager().createQuery(queryString);
					if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {	
						int rowStartIdx = Math.max(0,rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}
		
						if (rowStartIdxAndCount.length > 1) {
					    	int rowCount = Math.max(0,rowStartIdxAndCount[1]);
					    	if (rowCount > 0) {
					    		query.setMaxResults(rowCount);    
					    	}
						}
					}										
					return query.getResultList();
		} catch (RuntimeException re) {
						log.error("find all failed",  re);
				throw re;
		}
		finally
		{
			EntityManagerHelper.closeEntityManager();
		}
	}
	
}