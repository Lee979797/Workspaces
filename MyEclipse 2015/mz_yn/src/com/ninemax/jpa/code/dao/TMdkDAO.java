package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TMdk;
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
 * Time: 上午10:48
 */
public class TMdkDAO extends BaseDao{

    private static Logger log = Logger
			.getLogger(TMdkDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TMdk findById(String id) {
		log.info("finding Tczjl instance with id: " + id);
		try {
            TMdk instance = getEntityManager().find(TMdk.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TMdk> findByProperty(String propertyName, final Object value) {
		log.info("finding Tczjl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TMdk model where model."
					+ propertyName + "= :propertyValue order by model.createTime asc";
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
	public List<TMdk> findAll() {
		log.info("finding all TMdk instances");
		try {
			//xiaruibo 20170607 原版是查询所有，现在加上限制是否可用条件
//			final String queryString = "select model from TMdk model";	原版
			final String queryString = "select model from TMdk model where dmflag = '0'";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	public List<TMdk> findbyhql(String hql) {
		log.info("finding all TMdk instances");
		try {
			Query query = getEntityManager().createQuery(hql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}    finally {
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
		}     finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

}
