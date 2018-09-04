package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TQtmdk;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-8
 * Time: ÏÂÎç6:24
 */
public class TQtmdkDAO extends BaseDao{

    private static Logger log = Logger
			.getLogger(TQtmdkDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TQtmdk findById(String id) {
		log.info("finding Tczjl instance with id: " + id);
		try {
            TQtmdk instance = getEntityManager().find(TQtmdk.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TQtmdk> findByProperty(String propertyName, final Object value) {
		log.info("finding Tczjl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TQtmdk model where model."
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
	public List<TQtmdk> findByPropertyAndFlag(String propertyName, final Object value,int flag) {
		log.info("finding Tczjl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TQtmdk model where model.dmflag = '"+flag+"' and model."
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
	public List<TQtmdk> findAll() {
		log.info("finding all TQtmdk instances");
		try {
			final String queryString = "select model from TQtmdk model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}       finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	public List<TQtmdk> findbyhql(String hql) {
		log.info("finding all TQtmdk instances");
		try {
			Query query = getEntityManager().createQuery(hql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally {
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
		}    finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

}
