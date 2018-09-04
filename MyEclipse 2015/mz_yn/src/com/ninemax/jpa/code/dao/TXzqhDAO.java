package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.ScXzqhdz;
import com.ninemax.jpa.code.model.TXzqh;
import com.ninemax.jpa.code.model.TXzqh1;
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
public class TXzqhDAO extends BaseDao {

	private static Logger log = Logger
			.getLogger(TXzqhDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TXzqh findById(String id) {
		log.info("finding Tsp instance with id: " + id);
		try {
            TXzqh instance = getEntityManager().find(TXzqh.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

    public TXzqh1 findById1(String id) {
		log.info("finding Tsp instance with id: " + id);
		try {
            TXzqh1 instance = getEntityManager().find(TXzqh1.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TXzqh> findByProperty(String propertyName, final Object value) {
		log.info("finding Tsp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TXzqh model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TXzqh> findAll() {
		log.info("finding all Tsp instances");
		try {
			final String queryString = "select model from TXzqh model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
    @SuppressWarnings("unchecked")
    public List<TXzqh> findNoSJ() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TXzqh model ";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }  finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    @SuppressWarnings("unchecked")
	public List<TXzqh> findAll1() {
		log.info("finding all Tsp instances");
		try {
			final String queryString = "select model from TXzqh model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
    @SuppressWarnings("unchecked")
	public List<TXzqh> findAll2() {
		log.info("finding all Tsp instances");
		try {
			final String queryString = "select model from TXzqh model where 1=1 and substring(dm,5,2) != '00' ";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
    public List<ScXzqhdz> findAllXzqhDz() {
    	log.info("finding all Tsp instances");
    	try {
    		final String queryString = "select model from ScXzqhdz model";
    		Query query = getEntityManager().createQuery(queryString);
    		return query.getResultList();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}  finally {
    		EntityManagerHelper.closeEntityManager();
    	}
    }

	public List<TXzqh> findbyhql(String hql) {
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
	


	
	public List findbysql(String sql) {
		log.info("finding all sql's data instances");
		try {
			Query query = getEntityManager().createNativeQuery(sql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
    public List<TXzqh> getListPage(String userInput, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {
        List array = new ArrayList();
        String sql = "select * from sc_xzqh1 where 1=1 and substring(dm,5,2) != '00' ";
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
                TXzqh xzqh = new TXzqh();
                xzqh.setDm(crs.getString("dm"));
                xzqh.setMc(crs.getString("mc"));
                array.add(xzqh);
            }
        } catch (Exception e) {
            log.error(e);
        }   finally {
            EntityManagerHelper.closeEntityManager();
        }
        return array;
    }
}