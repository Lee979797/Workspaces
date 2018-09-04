package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.UserGroup;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.List;

public class UserGroupDAO extends BaseDao{

	private static Logger log = Logger.getLogger(UserGroupDAO.class);
	public static final String USERGROUP_NAME = "usergroupName";
	public static final String USERGROUP_MEMO = "usergroupMemo";
	public static final String USERGROUP_STATUS = "usergroupStatus";
	public static final String USERGROUP_KIND = "usergroupKind";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
    public UserGroup findById( int id) {
    				log.info("finding UserGroup instance with id: " + id);
	        try {
            UserGroup instance = getEntityManager().find(UserGroup.class, id);
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
	 * Find all UserGroup entities with a specific property value.  
	 
	  @param propertyName the name of the UserGroup property to query
	  @param value the property value to match
	  	  @return List<UserGroup> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<UserGroup> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding UserGroup instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from UserGroup model where model.usergroupStatus='0' and model." 
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
	public List<UserGroup> findByUsergroupName(Object usergroupName
	) {
		return findByProperty(USERGROUP_NAME, usergroupName
		);
	}
	
	public List<UserGroup> findByUsergroupMemo(Object usergroupMemo
	) {
		return findByProperty(USERGROUP_MEMO, usergroupMemo
		);
	}
	
	public List<UserGroup> findByUsergroupStatus(Object usergroupStatus
	) {
		return findByProperty(USERGROUP_STATUS, usergroupStatus
		);
	}
	
	public List<UserGroup> findByUsergroupKind(Object usergroupKind
	) {
		return findByProperty(USERGROUP_KIND, usergroupKind
		);
	}
	
	
	/**
	 * Find all UserGroup entities.
	  	  @return List<UserGroup> all UserGroup entities
	 */
	@SuppressWarnings("unchecked")
	public List<UserGroup> findAll(
		) {
					log.info("finding all UserGroup instances");
			try {
			final String queryString = "select model from UserGroup model where model.usergroupStatus='0' order by model.usergroupId desc";
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
	public int DeleteUserGroup(String groupId) {
					log.info("finding all UserGroup instances");
			try {
			final String queryString = "update UserGroup model set model.usergroupStatus='1' where model.usergroupId='"+groupId+"'";
								Query query = getEntityManager().createQuery(queryString);
					return query.executeUpdate();
		} catch (RuntimeException re) {
						log.error("find all failed",  re);
				throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<UserGroup> ListGroupByKind (String kind){
					log.info("finding ListGroupByKind UserGroup instances");
			try {
			final String queryString = "select model from UserGroup model where model.usergroupKind='"+kind+"' and model.usergroupStatus='0'";
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
	
	
	public List<UserGroup> findPageList(String searchField, String searchValue,String kind,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all UserGroup instances");
		try {
			String queryString = "from UserGroup model where model.usergroupStatus='0'";
			
			if(!"-1".equals(kind)){
				queryString +=" and model.usergroupKind = '"+kind+"'";
			}
			
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" like '%"+searchValue+"%'";
			}
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.usergroupId desc";
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
				new RuntimeException(e.getMessage(),e);
			}
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
	public boolean isExitUserGroupId(String usergroup_id) {
					log.info("finding all UserGroup instances");
					boolean reuslt = false;
			try {
			final String queryString = "select model from UserGroup model where model.usergroupId='"+usergroup_id+"'";
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