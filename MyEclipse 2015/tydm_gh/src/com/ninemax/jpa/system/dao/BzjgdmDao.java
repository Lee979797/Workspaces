package com.ninemax.jpa.system.dao;

// default package

import com.ninemax.jdbc.business.system.clsProvinceBus;
import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.Bzjgdm;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BzjgdmDao extends BaseDao{
	
	private static Logger log = Logger.getLogger(BzjgdmDao.class);
	// property constants
	public static final String DM = "dm";
	public static final String MC = "mc";
	public static final String FLAG = "flag";
	public static final String SUPERDM = "superdm";
	public static final String JGMC = "jgmc";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public Bzjgdm findById(String id) {
		log.info("finding Bzjgdm instance with id: " + id);
		try {
			Bzjgdm instance = getEntityManager().find(Bzjgdm.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed",  re);
			throw re;
		}finally
		{
			log.info("closing Bzjgdm instance with id: " + id);
			EntityManagerHelper.closeEntityManager();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Bzjgdm> findByProperty(String propertyName, final Object value) {
		log.info("finding Bzjgdm instance with property: "
				+ propertyName + ", value: ");
		try {
			final String queryString = "select model from Bzjgdm model where model."
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
			log.info("closing Bzjgdm instance with property: "+ propertyName + ", value: " + value);
			EntityManagerHelper.closeEntityManager();
		}
	}

	public List<Bzjgdm> findByMc(Object mc) {
		return findByProperty(MC, mc);
	}

	public List<Bzjgdm> findByFlag(Object flag) {
		return findByProperty(FLAG, flag);
	}

	public List<Bzjgdm> findBySuperdm(Object superdm) {
		return findByProperty(SUPERDM, superdm);
	}

	public List<Bzjgdm> findByJgmc(Object jgmc) {
		return findByProperty(JGMC, jgmc);
	}

	/**
	 * Find all Bzjgdm entities.
	 * 
	 * @return List<Bzjgdm> all Bzjgdm entities
	 */
	@SuppressWarnings("unchecked")
	public List<Bzjgdm> findAll() {
		log.info("finding all Bzjgdm instances");
		try {
			final String queryString = "select model from Bzjgdm model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed",  re);
			throw re;
		}
		finally
		{
			log.info("closing all Bzjgdm instances");
			EntityManagerHelper.closeEntityManager();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Bzjgdm> findAll1() {
		log.info("finding all Bzjgdm instances");
		try {
			//final String queryString = "select model from Bzjgdm model where 1=1 and substring(dm,5,2) != '00'";
			final String queryString = "select model from Bzjgdm model ";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed",  re);
			throw re;
		}
		finally
		{
			log.info("closing all Bzjgdm instances");
			EntityManagerHelper.closeEntityManager();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Bzjgdm> findAllXzqhdz() {
		log.info("finding all Bzjgdm instances");
		try {
			final String queryString = "select model from ScXzqhdz model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed",  re);
			throw re;
		}
		finally
		{
			log.info("closing all Bzjgdm instances");
			EntityManagerHelper.closeEntityManager();
		}
	}
	public List<Bzjgdm> findTop10() {
		log.info("finding all Bzjgdm instances");
		try {
			final String queryString = "select model from Bzjgdm model order by model.dm desc";
			Query query = getEntityManager().createQuery(queryString).setMaxResults(10);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed",  re);
			throw re;
		}finally
		{
			log.info("closing all Bzjgdm instances");
			EntityManagerHelper.closeEntityManager();
		}
	}
	public List<Bzjgdm> findPageList(String searchField, String searchValue,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent) {
		log.info("finding List<Bzjgdm> findPageList");
		try {
			String queryString = "from Bzjgdm model where 1=1 ";
			if(!clsStringTool.isEmpty(searchValue)){
				queryString += " and model."+searchField.trim()+" like '%"+searchValue+"%'";
			}
			String orderByContent="";
			if (!clsStringTool.isEmpty(orderbyColum)&& !clsStringTool.isEmpty(orderbyMethod)) {
				orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
			} else {
				orderByContent += " order by model.dm asc";
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
				log.error(e);
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed",  re);
			throw re;
		}finally
		{
			log.info("List<Bzjgdm> findPageList");
			EntityManagerHelper.closeEntityManager();
		}
	}
	

	public List<Bzjgdm> findBySuperId(String id) {
		log.info("finding List<Bzjgdm> findBySuperId "+id);
		if(!clsStringTool.isEmpty(id)){
			id = id.substring(0,2);
		}
		
		try {
			final String queryString = "select model from Bzjgdm model where model.dm like :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", id + "%");
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed",
					 re);
			throw re;
		}finally
		{
			log.info("closing List<Bzjgdm> findBySuperId "+id);
			EntityManagerHelper.closeEntityManager();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> mutiTableTest2(){
		log.info("finding List<Object[]> mutiTableTest2");
		try {

			final String queryString = "select t.*, d.code_cn,WorkUnit from DB_Nationalfb_detail t left join DB_EnterpriseInfo d  on  t.Code_id=d.code_Id where 1=1";
			Query query = getEntityManager().createNativeQuery(queryString).setMaxResults(10);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.info("find all failed",  re);
			throw re;
		}finally
		{
			log.info("closing List<Object[]> mutiTableTest2");
			EntityManagerHelper.closeEntityManager();
		}
	}


    public List<Bzjgdm> findJdbcBySuperId(String bzd) {
        List list = null;
        Bzjgdm bzjgdm = null;
        try {
            DataAccess dataAccessObject = new DataAccess();
            CachedRowSet crs = null;
            list = new ArrayList();
            String sql = "SELECT dm, mc FROM SC_bzjgdm where 1=1";
            //如果是市级机构
            if(!"0000".equals(bzd.substring(2))&&new clsProvinceBus().isSjFlag(bzd.substring(0, 4) + "00")){
                sql += " and dm like '"+bzd.substring(0, 4)+"%'";
            }else
                sql += " and substring(dm,1,4)+'00' not in (select dm from sc_center where dm not like '%0000') and dm like '"+bzd.substring(0,2)+"%' ";
          log.info("sql====="+sql);
            crs = dataAccessObject.query(sql);
            while (crs.next()){
                bzjgdm = new Bzjgdm();
                bzjgdm.setDm(crs.getString("dm"));
                bzjgdm.setMc(crs.getString("mc"));
                list.add(bzjgdm);
            }
        } catch (SQLException e) {
        	log.error("error", e);
            throw new RuntimeException(e.getMessage(),e);
        }
        return  list;
    }

    /**
     * 查询办证点所属的所有办证机构
     * @author zx
     * @date   2011.8.28
     * @param bzcode
     * @return
     */
    public List<Bzjgdm> findByBelongCode(String bzcode) {
        List list = null;
        Bzjgdm bzjgdm = null;
        try {
            DataAccess dataAccessObject = new DataAccess();
            CachedRowSet crs = null;
            list = new ArrayList();
            String sql = "SELECT dm, mc FROM SC_bzjgdm where 1=1";
            //如果后4位为0说明是省级办证点，但要排除省里面的城市做为省级办证点的城市;否则直接查出下面所属的办证机构点
            if(bzcode.endsWith("0000")){
                sql += " and substring(dm,1,4)+'00' not in (select dm from sc_center where dm not like '%0000') and dm like '"+bzcode.substring(0,2)+"%' ";
            }else
                sql += " and dm like '"+bzcode.substring(0, 4)+"%'";
          log.info("sql====="+sql);
            crs = dataAccessObject.query(sql);
            while (crs.next()){
                bzjgdm = new Bzjgdm();
                bzjgdm.setDm(crs.getString("dm"));
                bzjgdm.setMc(crs.getString("mc"));
                list.add(bzjgdm);
            }
        } catch (SQLException e) {
        	log.error("error", e);
            throw new RuntimeException(e.getMessage(),e);
        }
        return  list;
    }
}