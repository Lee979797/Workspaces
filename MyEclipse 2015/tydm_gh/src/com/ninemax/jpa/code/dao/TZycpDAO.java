package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TZycp;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Liuzy
 *
 */
public class TZycpDAO extends BaseDao {

	private static Logger log = Logger
			.getLogger(TZycpDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TZycp findById(String id) {
		log.info("finding Tsp instance with id: " + id);
		try {
            TZycp instance = getEntityManager().find(TZycp.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		} finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TZycp> findByProperty(String propertyName, final Object value) {
		log.info("finding Tsp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TZycp model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TZycp> findAll() {
		log.info("finding all Tsp instances");
		try {
			final String queryString = "select model from TZycp model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	public List<TZycp> findbyhql(String hql) {
		log.info("finding all Tsp instances");
		try {
			Query query = getEntityManager().createQuery(hql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
	

	public List<TZycp> findbysql(String sql) {
		log.info("finding all sql's data instances");
		try {
			Query query = getEntityManager().createNativeQuery(sql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
    public List<TZycp> getListPage(String userInput, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {
        List array = new ArrayList();
        String sql = "select * from t_zycp where 1=1 ";
        if(!clsStringTool.isEmpty(userInput)){
            sql += " and dm like '%"+userInput+"%' or mc like '%"+userInput+"%'";
        }
        String orderByContent = "dm asc";

        try {
            pageComponent.setTotalSize(sql);
            pageComponent.setPageSize(pageSize);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();
            pageComponent.setStartIndex(pageNo);
            pageComponent.setCurrentPage(pageNo);
            pageComponent.setOrderByContent(orderByContent);
            CachedRowSet crs = pageComponent.getResultList(sql);

            while (crs.next()) {
                TZycp zycp = new TZycp();
                zycp.setDm(crs.getString("dm"));
                zycp.setMc(crs.getString("mc"));
                array.add(zycp);
            }
        } catch (Exception e) {
            log.error(e);
        }

        return array;
    }
}