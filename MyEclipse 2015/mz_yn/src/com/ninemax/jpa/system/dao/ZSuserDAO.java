package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.ZSuser;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.List;



public class ZSuserDAO extends BaseDao  {
	private static Logger log = Logger.getLogger(ZSuserDAO.class);
	public static final String USER_NAME = "userName";
	public static final String USER_CHINESENAME = "userChinesename";
	public static final String USER_PASSWORD = "userPassword";
	public static final String ROLE_ID = "roleId";
	public static final String USERGROUP_ID = "usergroupId";
	public static final String OPERID = "operid";
	public static final String LASTLOGIN = "lastlogin";
	public static final String REGDATE = "regdate";
	public static final String USER_BRANCH = "userBranch";
	public static final String USER_IP = "userIp";
	public static final String IPVALID = "ipvalid";
	public static final String USER_STATUS = "userStatus";
	public static final String USER_KIND = "userKind";
	public static final String MEMO = "memo";
	public static final String USER_ADDRESS = "userAddress";
	public static final String USER_PHONE = "userPhone";
	public static final String USER_BIRTHDAY = "userBirthday";
	public static final String USER_SEX = "userSex";
	public static final String USER_POSTID = "userPostid";
	public static final String USER_MOBILE = "userMobile";
	public static final String USER_FAX = "userFax";
	public static final String USER_EMAIL = "userEmail";
	public static final String USER_CARDID = "userCardid";
	public static final String USER_TECH = "userTech";
	public static final String USER_PROVINCE = "userProvince";
	public static final String USER_WORK = "userWork";
	public static final String USER_POSTKIND = "userPostkind";
	public static final String USER_LOSTPWSHOW = "userLostpwshow";
	public static final String USER_SHOWPROBLEM = "userShowproblem";
	public static final String USER_ARTICLEDB = "userArticledb";
	public static final String ISSYSUSER = "issysuser";
	public static final String ITEM1 = "item1";
	public static final String ITEM2 = "item2";
	public static final String USER_EDUCATION = "userEducation";
	public static final String USER_HASBLOG = "userHasblog";
	public static final String PNG = "png";
	public static final String USER_CLASS = "userClass";
	public static final String USER_LEVEL = "userLevel";
	public static final String USER_INBRACH = "userInbrach";
	public static final String USER_CAREER = "userCareer";
	public static final String USER_POLITICS = "userPolitics";
	public static final String USER_COMPANY_ADDRESS = "userCompanyAddress";
	public static final String USER_ICQ = "userIcq";
	public static final String USER_NATURE = "userNature";
	public static final String CERT_ID = "certId";
	public static final String USER_AVATAR = "userAvatar";
	public static final String USER_SCORE = "userScore";
	public static final String BZJGDM = "bzjgdm";
	public static final String ZRXZQU = "zrxzqu";
	public static final String DB = "db";
	public static final String JGDM = "jgdm";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	
    public ZSuser findById( Integer id) {
    				log.info("finding ZSuser instance with id: " + id);
	        try {
            ZSuser instance = getEntityManager().find(ZSuser.class, id);
            return instance;
        } catch (RuntimeException re) {
        				log.error("find failed",  re);
	            throw re;
        }
    }    
    


    @SuppressWarnings("unchecked")
    public List<ZSuser> findByProperty(String propertyName, final Object value
        ) {
    				log.info("finding ZSuser instance with property: " + propertyName + ", value: " + value);
			try {
			final String queryString = "select model from ZSuser model where model." 
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
	 * Find all ZSuser entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<ZSuser> all ZSuser entities
	 */
	@SuppressWarnings("unchecked")
	public List<ZSuser> findAll(
		final int...rowStartIdxAndCount
		) {
					log.info("finding all ZSuser instances");
			try {
			final String queryString = "select model from ZSuser model";
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
	}
	
	@SuppressWarnings("unchecked")
	public List<ZSuser> FindByName(String user_name) {
					log.info("finding FindByName User instances");
			try {
			final String queryString = "select model from ZSuser model where model.userName='"+user_name+"'";
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
	
	public boolean setLastLogin(String user_id) {
		log.info("finding setLastLogin ZSuser instances");
		boolean reuslt =false;
		try {
		final String queryString = "update ZSuser model set model.lastlogin='"+com.ninemax.jpa.util.DateProcess.getSysTime()+"' where user_id='"+user_id+"'";
							Query query = getEntityManager().createQuery(queryString);
				if(query.executeUpdate()>0){
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
	
	
	public List<ZSuser> findPageList(String searchField, String searchValue,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all ZSuser instances");
		try {
			String queryString = "from ZSuser model where model.userStatus='0'";
			
					
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" like '%"+searchValue+"%'";
			}
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.userId desc";
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
	
}