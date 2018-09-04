package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.UgRoleDetail;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class UgRoleDetailDAO extends BaseDao{

	private static Logger log = Logger.getLogger(UgRoleDetailDAO.class);
	public static final String USERGROUP_ID = "usergroupId";
	public static final String ROLE_ID = "roleId";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public UgRoleDetail findById( Long id) {
    				log.info("finding UgRoleDetail instance with id: " + id);
	        try {
            UgRoleDetail instance = getEntityManager().find(UgRoleDetail.class, id);
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
	 * Find all UgRoleDetail entities with a specific property value.  
	 
	  @param propertyName the name of the UgRoleDetail property to query
	  @param value the property value to match
	  	  @return List<UgRoleDetail> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<UgRoleDetail> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding UgRoleDetail instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from UgRoleDetail model where model." 
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
	public List<UgRoleDetail> findByUsergroupId(Object usergroupId
	) {
		return findByProperty(USERGROUP_ID, usergroupId
		);
	}
	
	public List<UgRoleDetail> findByRoleId(Object roleId
	) {
		return findByProperty(ROLE_ID, roleId
		);
	}
	
	
	/**
	 * Find all UgRoleDetail entities.
	  	  @return List<UgRoleDetail> all UgRoleDetail entities
	 */
	@SuppressWarnings("unchecked")
	public List<UgRoleDetail> findAll(
		) {
					log.info("finding all UgRoleDetail instances");
			try {
			final String queryString = "select model from UgRoleDetail model";
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
	
	
	
	
	@SuppressWarnings("unchecked")
	public boolean DeleteByGroupId(String group_id) {
					log.info("finding all UserGroup instances");
					boolean reuslt = false;
			try {
			final String queryString = "delete from  UgRoleDetail model where model.usergroupId='"+group_id+"'";
								Query query = getEntityManager().createQuery(queryString);
					
					if (query.executeUpdate()>0) {
						reuslt = true;
					}
		} catch (RuntimeException re) {
						log.error("find all failed",  re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
		
		return reuslt;
	}
	
}