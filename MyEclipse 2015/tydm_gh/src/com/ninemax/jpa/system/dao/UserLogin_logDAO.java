package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.UserLogin_log;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class UserLogin_logDAO extends BaseDao{

	private static Logger log = Logger.getLogger(UserLogin_logDAO.class);
	public static final String USERID = "userid";
	public static final String USERNAME = "username";
	public static final String USER_IP = "userIp";
	public static final String MEMO = "memo";
	public static final String LOGINDATE = "logindate";




	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		
	public UserLogin_log findById(String id) {
		log.info("finding UserLogin_log instance with id: " + id);
		try {
			UserLogin_log instance = getEntityManager().find(UserLogin_log.class, id);
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
	 * Find all UserLogin_log entities.
	  	  @return List<UserLogin_log> all UserLogin_log entities
	 */
	@SuppressWarnings("unchecked")
	public List<UserLogin_log> findAll(
		) {
					log.info("finding all UserLogin_log instances");
			try {
			final String queryString = "select model from UserLogin_log model";
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
	
	// 省级用户查询
	public List<UserLogin_log> findPageList(String searchField, String searchValue,String userLoginValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all UserLogin_log instances");
		try {
			String queryString = "from UserLogin_log model where Rtrim(model.userIp) <> '0:0:0:0:0:0:0:1' and Rtrim(model.userIp) <> '127.0.0.1'  and Rtrim(model.userIp) <> '127.0.1.1'";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//	Date sdate = sdf.parse(startDate+" 00:00:00");
			startDate = startDate + " 00:00:00";
			if(!clsStringTool.isEmpty(startDate) ){
				queryString += " and model.logindate >= ? ";
			}
		//	Date edate = sdf.parse(endDate+" 23:59:59");
			endDate = endDate + " 23:59:59";
			if(!clsStringTool.isEmpty(endDate) ){
				queryString += " and model.logindate <= ? ";
			}
			
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" like '%"+searchValue.trim()+"%'";
			}

            if(!clsStringTool.isEmpty(userLoginValue)){
                queryString += " and model."+searchField.trim()+" = '"+userLoginValue.trim()+"'";
            }

            log.info("queryString======"+queryString);

			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.loginid desc";
			}
			Query query = getEntityManager().createQuery(queryString+orderByContent);
			query.setFirstResult(pageSize*(pageNo-1));
			query.setMaxResults(pageSize);
			Object params[]={startDate,endDate};
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
	// 市级用户查询
	public List<UserLogin_log> findPageByCityList(String bzjgdm,String searchField, String searchValue,String userLoginValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all UserLogin_log instances");
		try {
			StringBuilder queryString = new StringBuilder();;
			queryString.append(" from UserLogin_log model ");
			queryString.append(" where Rtrim(model.userIp) <> '0:0:0:0:0:0:0:1' and Rtrim(model.userIp) <> '127.0.0.1'  and Rtrim(model.userIp) <> '127.0.1.1'");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//	Date sdate = sdf.parse(startDate+" 00:00:00");
			startDate = startDate + " 00:00:00";
			if(!clsStringTool.isEmpty(startDate) ){
				queryString.append(" and model.logindate >= ? ");
			}
			//	Date edate = sdf.parse(endDate+" 23:59:59");
			endDate = endDate + " 23:59:59";
			if(!clsStringTool.isEmpty(endDate) ){
				queryString.append(" and model.logindate <= ? ");
			}	
			if(!clsStringTool.isEmpty(searchValue)){
				queryString.append(" and model."+searchField.trim()+" like '%"+searchValue.trim()+"%'");
			}	
			if(!clsStringTool.isEmpty(userLoginValue)){
				queryString.append(" and model."+searchField.trim()+" = '"+userLoginValue.trim()+"'");
			}
		    // 省级用户所属办证机构

			if(!clsStringTool.isEmpty(bzjgdm)){
				queryString.append(" and model.userid in (select su.userId from User su where su.bzjgdm  like '"+bzjgdm+"%')");
			}
			log.info("queryString======"+queryString);
			
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.loginid desc";
			}
			Query query = getEntityManager().createQuery(queryString+orderByContent);
			query.setFirstResult(pageSize*(pageNo-1));
			query.setMaxResults(pageSize);
			Object params[]={startDate,endDate};
			setQueryParams(query,params);
			try {
				pageComponent.setTotalSize(queryString.toString(),params);
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
	// 仅用户查询
	public List<UserLogin_log> findPageByUserList(String userId,String searchField, String searchValue,String userLoginValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all UserLogin_log instances");
		try {
			StringBuilder queryString = new StringBuilder();;
			queryString.append(" from UserLogin_log model ");
			queryString.append(" where Rtrim(model.userIp) <> '0:0:0:0:0:0:0:1' and Rtrim(model.userIp) <> '127.0.0.1'  and Rtrim(model.userIp) <> '127.0.1.1'");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//	Date sdate = sdf.parse(startDate+" 00:00:00");
			startDate = startDate + " 00:00:00";
			if(!clsStringTool.isEmpty(startDate) ){
				queryString.append(" and model.logindate >= ? ");
			}
			//	Date edate = sdf.parse(endDate+" 23:59:59");
			endDate = endDate + " 23:59:59";
			if(!clsStringTool.isEmpty(endDate) ){
				queryString.append(" and model.logindate <= ? ");
			}	
			if(!clsStringTool.isEmpty(searchValue)){
				queryString.append(" and model."+searchField.trim()+" like '%"+searchValue.trim()+"%'");
			}	
			if(!clsStringTool.isEmpty(userLoginValue)){
				queryString.append(" and model."+searchField.trim()+" = '"+userLoginValue.trim()+"'");
			}
			if(!clsStringTool.isEmpty(userId)){
				queryString.append(" and  model.userid="+userId);
			}
		
			log.info("queryString======"+queryString);
			
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.loginid desc";
			}
			Query query = getEntityManager().createQuery(queryString+orderByContent);
			query.setFirstResult(pageSize*(pageNo-1));
			query.setMaxResults(pageSize);
			Object params[]={startDate,endDate};
			setQueryParams(query,params);
			try {
				pageComponent.setTotalSize(queryString.toString(),params);
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