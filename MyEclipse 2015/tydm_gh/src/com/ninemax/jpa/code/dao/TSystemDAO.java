package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TSystem;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Liuzy
 *
 */
public class TSystemDAO extends BaseDao {

	private static Logger log = Logger
			.getLogger(TSystemDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TSystem findById(String id) {
		log.info("finding Tsp instance with id: " + id);
		try {
            TSystem instance = getEntityManager().find(TSystem.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TSystem> findByProperty(String propertyName, final Object value) {
		log.info("finding Tsp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TSystem model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}     finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
    public List<TSystem> findByPropertys(final Map<String, Object> map) {
        try {
            StringBuilder where = new StringBuilder("select model from TSystem model where ");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and"));

                Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
                for (Map.Entry entry : map.entrySet()) {
                    query.setParameter((String) entry.getKey(), entry.getValue());
                }

                return query.getResultList();
            }
            return null;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
	@SuppressWarnings("unchecked")
	public List<TSystem> findAll() {
		log.info("finding all Tsp instances");
		try {
			final String queryString = "select model from TSystem model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}            finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	public List<TSystem> findbyhql(String hql) {
		log.info("finding all Tsp instances");
		try {
			Query query = getEntityManager().createQuery(hql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}       finally {
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