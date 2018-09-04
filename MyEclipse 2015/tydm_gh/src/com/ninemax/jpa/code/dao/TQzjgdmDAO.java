package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TQzjgdm;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
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
public class TQzjgdmDAO extends BaseDao {

	private static Logger log = Logger
			.getLogger(TQzjgdmDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TQzjgdm findById(String id) {
		log.info("finding Tsp instance with id: " + id);
		try {
            TQzjgdm instance = getEntityManager().find(TQzjgdm.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		} finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TQzjgdm> findByProperty(String propertyName, final Object value) {
		log.info("finding Tsp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TQzjgdm model where  model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		} finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

    public List<TQzjgdm> findByPropertys(final Map<String, Object> map) {
        try {
            StringBuilder where = new StringBuilder("select model from TQzjgdm model where ");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and")).toString();

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
	public List<TQzjgdm> findAll() {
		log.info("finding all Tsp instances");
		try {
			final String queryString = "select model from TQzjgdm model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	public List<TQzjgdm> findbyhql(String hql) {
		log.info("finding all Tsp instances");
		try {
			Query query = getEntityManager().createQuery(hql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}  finally {
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
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

    public List<TQzjgdm> listQzTjgdm(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List<Object> params) {
        log.info("finding listQzTjgdm");
        List<TQzjgdm> list=null;
        Query query = null;
		try {
            if(pageno==0){
                pageno = 1;
            }
			query = getEntityManager().createQuery(jql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			setQueryParams(query, params);
			pageComponent.setTotalSize(jql.substring(0,jql.indexOf("order")),params);
			pageComponent.setPageSize(rowNumsView);
			pageComponent.setTotalPages();
			pageComponent.setLastPage();
			pageComponent.setStartIndex(pageno);
			pageComponent.setCurrentPage(pageno);
            list= query.getResultList();
        } catch (Exception re) {
			log.error("find all failed", re);
		}finally {
            EntityManagerHelper.closeEntityManager();
        }
        return  list;
    }
}