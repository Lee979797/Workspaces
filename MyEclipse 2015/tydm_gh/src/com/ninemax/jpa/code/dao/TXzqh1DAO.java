package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TXzqh1;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-28
 * Time: ÏÂÎç1:12
 */
public class TXzqh1DAO extends BaseDao{
    
    private static Logger log = Logger
			.getLogger(TXzqh1DAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TXzqh1 findById(String id) {
		log.info("finding TXzqh1 instance with id: " + id);
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
	public List<TXzqh1> findByProperty(String propertyName, final Object value) {
		log.info("finding TXzqh1 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TXzqh1 model where model."
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
	public List<TXzqh1> findAll() {
		log.info("finding all TXzqh1 instances");
		try {
			final String queryString = "select model from TXzqh1 model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
}
