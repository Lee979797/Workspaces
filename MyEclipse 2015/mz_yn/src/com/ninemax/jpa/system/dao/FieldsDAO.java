package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.collection.model.Fields;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;



public class FieldsDAO  {
	private static Logger log = Logger.getLogger(FieldsDAO.class);
	public static final String FIELD_NAME = "fieldName";
	public static final String FIELD_CODE = "fieldCode";
	public static final String FIELDTYPE_ID = "fieldtypeId";
	public static final String FIELD_LENGTH = "fieldLength";
	public static final String FIELD_COLOR = "fieldColor";
	public static final String IS_SHOW = "isShow";
	public static final String IS_INPUT = "isInput";
	public static final String BELONG_TABLE = "belongTable";
	public static final String MEMO1 = "memo1";
	public static final String MEMO2 = "memo2";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Fields entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   FieldsDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Fields entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Fields entity) {
    				EntityManagerHelper.log("saving Fields instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			log.info("save successful");
	        } catch (RuntimeException re) {
        				log.error("save failed",  re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Fields entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   FieldsDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Fields entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Fields entity) {
    				log.info("deleting Fields instance");
	        try {
        	entity = getEntityManager().getReference(Fields.class, entity.getFieldId());
            getEntityManager().remove(entity);
            			log.info("delete successful");
	        } catch (RuntimeException re) {
        				log.error("delete failed",  re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Fields entity and return it or a copy of it to the sender. 
	 A copy of the Fields entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = FieldsDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Fields entity to update
	 @returns Fields the persisted Fields entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Fields update(Fields entity) {
    				log.info("updating Fields instance");
	        try {
            Fields result = getEntityManager().merge(entity);
            			log.info("update successful");
	            return result;
        } catch (RuntimeException re) {
        				log.error("update failed",  re);
	            throw re;
        }
    }
    
    public Fields findById( String id) {
    				log.info("finding Fields instance with id: " + id);
	        try {
            Fields instance = getEntityManager().find(Fields.class, id);
            return instance;
        } catch (RuntimeException re) {
        				log.error("find failed",  re);
	            throw re;
        }
    }    
    

/**
	 * Find all Fields entities with a specific property value.  
	 
	  @param propertyName the name of the Fields property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
	  	  @return List<Fields> found by query
	 */
    @SuppressWarnings("unchecked")
	public List<Fields> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
		log.info("finding Fields instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Fields model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}		
	public List<Fields> findByFieldName(Object fieldName) {
		return findByProperty(FIELD_NAME, fieldName);
	}
	
	public List<Fields> findByFieldCode(Object fieldCode) {
		return findByProperty(FIELD_CODE, fieldCode);
	}
	
	
	public List<Fields> findByBelongTable(Object belongTable) {
		return findByProperty(BELONG_TABLE, belongTable);
	}
	
	
	/**
	 * Find all Fields entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Fields> all Fields entities
	 */
	@SuppressWarnings("unchecked")
	public List<Fields> findAll(
		final int...rowStartIdxAndCount
		) {
					log.info("finding all Fields instances");
			try {
			final String queryString = "select model from Fields model";
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
						log.error("find all failed", re);
				throw re;
		}
	}
	
}