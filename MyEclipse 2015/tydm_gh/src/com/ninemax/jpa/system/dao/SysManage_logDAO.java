package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SysManage_logDAO  extends BaseDao{
	private static Logger log = Logger.getLogger(SysManage_logDAO.class);
	public static final String USERID = "userid";
	public static final String USERNAME = "username";
	public static final String OPERKIND_ID = "operkindId";
	public static final String OPERVALUE = "opervalue";
	public static final String MEMO = "memo";
	public static final String OPERDATE = "operdate";




	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		
    public SysManage_log findById( String id) {
    				log.info("finding SysManage_log instance with id: " + id);
	        try {
            SysManage_log instance = getEntityManager().find(SysManage_log.class, id);
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
	 * Find all SysManage_log entities.
	  	  @return List<SysManage_log> all SysManage_log entities
	 */
	@SuppressWarnings("unchecked")
	public List<SysManage_log> findAll(
		) {
					log.info("finding all SysManage_log instances");
			try {
			final String queryString = "select model from SysManage_log model";
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
	
	public List<SysManage_log> findPageList(String searchField, String searchValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent)  throws ParseException {
		log.info("finding all SysManage_log instances");
		try {
			String queryString = "from SysManage_log model where 1=1";
			
		//	queryString += " to_char(model.operdate,'YYYY-MM-DD HH24:mi:ss') > '"+startDate+" 00:00:00' and to_char(model.operdate,'YYYY-MM-DD HH24:mi:ss') < '"+endDate+" 23:59:59' ";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date sdate = sdf.parse(startDate);
			if(!clsStringTool.isEmpty(startDate) ){
				queryString += " and model.operdate >= ? ";
			}
			Date edate = sdf.parse(endDate);
			if(!clsStringTool.isEmpty(endDate) ){
				queryString += " and model.operdate <= ? ";
			}
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" = '"+searchValue+"'";
			}
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.operdate desc";
			}
			Query query = getEntityManager().createQuery(queryString+orderByContent);
			query.setFirstResult(pageSize*(pageNo-1));
			query.setMaxResults(pageSize);
			Object params[]={sdate, DateUtil.dayAfter(edate,1)};
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