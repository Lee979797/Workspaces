package com.ninemax.jpa.system.dao;
// default package

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class OperationDAO extends BaseDao {

	private static Logger log = Logger.getLogger(OperationDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
	@SuppressWarnings("unchecked")
	public List findPageList(String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageNo, int pageSize,clsPageComponent pageComponent)throws ParseException {
		
		
		List array = new ArrayList();
		try {
			String sql = "select sum(a.xlrl) xlrl,sum(b.shangchuan) shangchuan,sum(c.fankui) fankui,a.dates dates from (select count(distinct code_id) xlrl,CONVERT(varchar(100), finishdate, 23) as dates from DB_EnterpriseInfo where status='0' group  by CONVERT(varchar(100), finishdate, 23)) a "
				+" left join( " 
				+" select sum(datatotal) shangchuan,CONVERT(varchar(100), upload_date, 23) as dates from DB_Upload_log group by CONVERT(varchar(100), upload_date, 23)) b on a.dates = b.dates "
				+" left join( "
				+" select sum(feedback_count) fankui,CONVERT(varchar(100),getdate, 23) as dates from db_nationalfeedback group by CONVERT(varchar(100),getdate, 23)) c on a.dates=c.dates ";

				
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							//Date sdate = sdf.parse(startDate+" 00:00:00");
							if(!clsStringTool.isEmpty(startDate) ){
								sql += " where a.dates >= '"+startDate+" 00:00:00' ";
							}
							//Date edate = sdf.parse(endDate+" 23:59:59");
							if(!clsStringTool.isEmpty(endDate) ){
								sql += " and a.dates <= '"+endDate+" 23:59:59' ";
							}
							sql += "group by a.dates ";
							
							String orderByContent="";
							if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
								orderByContent +=  orderbyColum + " " + orderbyMethod;
							} else {
								orderByContent += " dates desc";
							}

			
			try {
				pageComponent.setTotalSize(sql);
				pageComponent.setPageSize(pageSize);
				pageComponent.setTotalPages();
				pageComponent.setLastPage();
				pageComponent.setStartIndex(pageNo);
				pageComponent.setCurrentPage(pageNo);
				pageComponent.setOrderByContent(orderByContent);
				CachedRowSet crs = pageComponent.getResultList(sql);	

				while(crs.next()){								
					Object[] productObj = new Object[4];
					productObj[0]=crs.getObject("xlrl");
					productObj[1]=crs.getObject("shangchuan");
					productObj[2]=crs.getObject("fankui");
					productObj[3]=crs.getObject("dates");
					
					array.add(productObj);					
				}
			} catch (Exception e) {
				log.error("find all failed",  e);
				throw new RuntimeException(e.getMessage(),e);
			}
		
			return array;
		} catch (RuntimeException re) {
			log.error("find all failed",  re);
			throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }

	}
	

}