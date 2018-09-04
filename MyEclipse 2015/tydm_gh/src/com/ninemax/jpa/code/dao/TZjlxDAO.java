package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TZjlx;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * 
 * @author Liuzy
 *
 */
public class TZjlxDAO extends BaseDao {

	private static Logger log = Logger
			.getLogger(TZjlxDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TZjlx findById(String id) {
		log.info("finding Tsp instance with id: " + id);
		try {
            TZjlx instance = getEntityManager().find(TZjlx.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TZjlx> findByProperty(String propertyName, final Object value) {
		log.info("finding Tsp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TZjlx model where model."
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
	public List<TZjlx> findAll() {
		log.info("finding all Tsp instances");
		try {
			final String queryString = "select model from TZjlx model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	public List<TZjlx> findbyhql(String hql) {
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
}