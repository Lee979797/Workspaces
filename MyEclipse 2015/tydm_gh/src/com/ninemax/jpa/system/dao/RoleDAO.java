package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.Role;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.List;



public class RoleDAO  extends BaseDao{
	private static Logger log = Logger.getLogger(RoleDAO.class);
	public static final String ROLE_NAME = "roleName";
	public static final String ROLE_KIND = "roleKind";
	public static final String ROLE_MEMO = "roleMemo";
	public static final String ROLE_STATUS = "roleStatus";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public Role findById( int id) {
    				log.info("finding Role instance with id: " + id);
	        try {
            Role instance = getEntityManager().find(Role.class, id);
            return instance;
        } catch (RuntimeException re) {
        				log.error("find failed",  re);
	            throw re;
        }finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
        
    }    
    
    @SuppressWarnings("unchecked")
	public List<Role> findByProperty(String propertyName, final Object value) {
		log.info("finding Role instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Role model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed",
					 re);
			throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}

	public List<Role> findByRoleName(Object role_name) {
		return findByProperty(ROLE_NAME, role_name);
	}
	
	public List<Role> findByRoleKind(Object role_kind) {
		return findByProperty(ROLE_KIND, role_kind);
	}
	
	
	/**
	 * Find all Role entities.
	  	  @return List<Role> all Role entities
	 */
	@SuppressWarnings("unchecked")
	public List<Role> findAll(
		) {
					log.info("finding all Role instances");
			try {
			final String queryString = "select model from Role model where model.roleStatus='0'";
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
	
	
	
	public List<Role> findPageList(String searchField, String searchValue,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all Role instances");
		try {
			String queryString = "from Role model where model.roleStatus='0'";
			
		
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" like '%"+searchValue+"%'";
			}
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.roleId desc";
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
				// TODO Auto-generated catch block
				log.error(e);
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
	
}