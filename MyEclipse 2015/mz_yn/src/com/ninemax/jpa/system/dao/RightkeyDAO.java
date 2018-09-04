package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.Rightkey;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;



public class RightkeyDAO  extends BaseDao{
	private static Logger log = Logger.getLogger(RightkeyDAO.class);
	public static final String RIGHTKEY_NAME = "rightkeyName";
	public static final String RIGHTKEY_DEPTH = "rightkeyDepth";
	public static final String RIGHTKEY_KIND = "rightkeyKind";
	public static final String RIGHTKEY_FUNC = "rightkeyFunc";
	public static final String RIGHTKEY_FULLNAME = "rightkeyFullname";
	public static final String PICTRUE = "pictrue";
	public static final String PARENTID = "parentid";
	public static final String LINKPAGE = "linkpage";
	public static final String ORDERBY = "orderby";
	public static final String TYPE = "type";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public Rightkey findById( String id) {
    				log.info("finding Rightkey instance with id: " + id);
	        try {
            Rightkey instance = getEntityManager().find(Rightkey.class, id);
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
	 * Find all Rightkey entities with a specific property value.  
	 
	  @param propertyName the name of the Rightkey property to query
	  @param value the property value to match
	  	  @return List<Rightkey> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Rightkey> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding Rightkey instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from Rightkey model where model." 
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
	public List<Rightkey> findByRightkeyName(Object rightkeyName
	) {
		return findByProperty(RIGHTKEY_NAME, rightkeyName
		);
	}
	
	public List<Rightkey> findByRightkeyDepth(Object rightkeyDepth
	) {
		return findByProperty(RIGHTKEY_DEPTH, rightkeyDepth
		);
	}
	
	public List<Rightkey> findByRightkeyKind(Object rightkeyKind
	) {
		return findByProperty(RIGHTKEY_KIND, rightkeyKind
		);
	}
	
	public List<Rightkey> findByRightkeyFunc(Object rightkeyFunc
	) {
		return findByProperty(RIGHTKEY_FUNC, rightkeyFunc
		);
	}
	
	public List<Rightkey> findByRightkeyFullname(Object rightkeyFullname
	) {
		return findByProperty(RIGHTKEY_FULLNAME, rightkeyFullname
		);
	}
	
	public List<Rightkey> findByPictrue(Object pictrue
	) {
		return findByProperty(PICTRUE, pictrue
		);
	}
	
	public List<Rightkey> findByParentid(Object parentid
	) {
		return findByProperty(PARENTID, parentid
		);
	}
	
	public List<Rightkey> findByLinkpage(Object linkpage
	) {
		return findByProperty(LINKPAGE, linkpage
		);
	}
	
	public List<Rightkey> findByOrderby(Object orderby
	) {
		return findByProperty(ORDERBY, orderby
		);
	}
	
	public List<Rightkey> findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	
	/**
	 * Find all Rightkey entities.
	  	  @return List<Rightkey> all Rightkey entities
	 */
	@SuppressWarnings("unchecked")
	public List<Rightkey> findAll(
		) {
					log.info("finding all Rightkey instances");
			try {
			final String queryString = "select model from Rightkey model";
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
	public List<Rightkey> ListParentNode(
		) {
					log.info("finding ListParentNode Rightkey instances");
			try {
			final String queryString = "select model from Rightkey model where model.rightkeyDepth='1' order by model.orderby asc";
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
	public List<Rightkey> ListChildNode(String parentId) {
					log.info("finding ListParentNode Rightkey instances");
			try {
			final String queryString = "select model from Rightkey model where model.parentid = '"+parentId+"' order by model.orderby asc";
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