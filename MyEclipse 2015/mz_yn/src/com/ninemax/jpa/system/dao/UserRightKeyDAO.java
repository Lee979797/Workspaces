package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.UserRightKey;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;


public class UserRightKeyDAO extends BaseDao{
	//property constants
	public static final String USER_ID = "userId";
	public static final String RIGHTKEY_ID = "rightkeyId";
	public static final String ISROLE = "isrole";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public UserRightKey findById( Long id) {
    				EntityManagerHelper.log("finding UserRightKey instance with id: " + id, Level.INFO, null);
	        try {
            UserRightKey instance = getEntityManager().find(UserRightKey.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
    }    
    


    @SuppressWarnings("unchecked")
    public List<UserRightKey> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding UserRightKey instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from UserRightKey model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}			
	public List<UserRightKey> findByUserId(Object userId
	) {
		return findByProperty(USER_ID, userId
		);
	}
	
	public List<UserRightKey> findByRightkeyId(Object rightkeyId
	) {
		return findByProperty(RIGHTKEY_ID, rightkeyId
		);
	}
	
	public List<UserRightKey> findByIsrole(Object isrole
	) {
		return findByProperty(ISROLE, isrole
		);
	}
	
	
	/**
	 * Find all UserRightKey entities.
	  	  @return List<UserRightKey> all UserRightKey entities
	 */
	@SuppressWarnings("unchecked")
	public List<UserRightKey> findAll(
		) {
					EntityManagerHelper.log("finding all UserRightKey instances", Level.INFO, null);
			try {
			final String queryString = "select model from UserRightKey model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}
	
	public boolean DeleteKeyByUserId(String userId) {
		EntityManagerHelper.log("finding setLastLogin User instances", Level.INFO, null);
		boolean reuslt =false;
		try {
		final String queryString = "delete from  UserRightKey model where model.userId='"+userId+"' and model.isrole='0'";
							Query query = getEntityManager().createQuery(queryString);
				if(query.executeUpdate()>0){
					reuslt = true;
				}
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
		
		return reuslt;
	}
	
}